package com.alura.persistencia;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.RollbackException;

import com.alura.logica.dao.HuespedDao;
import com.alura.logica.dao.ReservaDao;
import com.alura.logica.dao.UsuarioDao;
import com.alura.logica.modelo.Huesped;
import com.alura.logica.modelo.Reserva;
import com.alura.logica.modelo.Usuario;
import com.alura.persistencia.utils.JPAUtils;

public class Controladora {
	EntityManager em = JPAUtils.getEntityManager();
	UsuarioDao usuarioDao = new UsuarioDao(em);
	ReservaDao reservaDao = new ReservaDao(em);
	HuespedDao huespedDao = new HuespedDao(em);

	public boolean login(String txtUsuario, String passwordClave) {
		Usuario usuario = new Usuario();
		usuario.setUsuario(txtUsuario);
		usuario.setClave(passwordClave);
		
		try{
			em.getTransaction().begin();
			
			List<Usuario> listaUsuario =  usuarioDao.consultarPorNombre(usuario.getUsuario());
			
			em.getTransaction().commit();
			
			for(Usuario usuarioConsulta: listaUsuario ) {
				
				if(usuarioConsulta.getUsuario().equals(usuario.getUsuario())  && usuarioConsulta.getClave().equals(usuario.getClave()))  {
					return true;
				}else {
					return false;
				}
			}
						
		}catch(Exception e) {
				return false;
		}
		return false;
	}

	public Reserva crearReserva(Date fechaIngreso, Date fechaSalida, Double valorReserva, String medioPago) {
		Reserva reserva = new Reserva();
		Huesped huesped = new Huesped();
		huesped.setReserva(reserva);
		
		
		reserva.setFechaIngreso(fechaIngreso);
		reserva.setFechaSalida(fechaSalida);
		reserva.setValorReserva(valorReserva);
		reserva.setMedioPago(medioPago);
		reserva.setHuesped(huesped);
		
		System.out.println(reserva.getId());
		
		try{
			em.getTransaction().begin();
			
			huespedDao.guardar(huesped);

			reservaDao.guardar(reserva);
			
			em.getTransaction().commit();
			System.out.println(reserva.getId());
			
			return reserva;
						
		}catch (RollbackException e) {
		    Throwable cause = e.getCause();
		    while (cause != null) {
		        System.out.println("Causa: " + cause.getMessage());
		        cause = cause.getCause();
		    }
		    return null;
		}
	}

	public boolean completarDatosHuesped(String nombre, String apellido, Date fechaNacimiento, String nacionalidad,
			String telefono, Reserva reserva) {
		
		Huesped huesped = reserva.getHuesped();
		huesped.setNombre(nombre);
		huesped.setApellido(apellido);
		huesped.setFechaNacimiento(fechaNacimiento);
		huesped.setNacionalidad(nacionalidad);
		huesped.setTelefono(telefono);

		try{
			em.getTransaction().begin();
			
			huespedDao.actualizar(huesped);
			
			em.getTransaction().commit();
			
			return true;
						
		}catch (RollbackException e) {
		    Throwable cause = e.getCause();
		    while (cause != null) {
		        System.out.println("Causa: " + cause.getMessage());
		        cause = cause.getCause();
		    }
		    return false;
		}
	}

	public List<Reserva> traerReservasPorParametros(String parametroBusqueda) {
		
		em.getTransaction().begin();
		

		List<Reserva> listaReserva =  reservaDao.consultarTodosConParametroDeHuesped(parametroBusqueda);
		
		em.getTransaction().commit();
		
		return listaReserva;
	}

	public List<Huesped> traerHuespedesPorParametros(String parametroBusqueda) {
	
		em.getTransaction().begin();
		

		List<Huesped> listaHuesped =  huespedDao.consultarTodosConParametro(parametroBusqueda);
		
		em.getTransaction().commit();
		
		return listaHuesped;
	}

	public List<Reserva> traerTodosReservas() {
		em.getTransaction().begin();
		
		List<Reserva> listaReserva = reservaDao.consultarTodos();
		
		em.getTransaction().commit();
		return listaReserva;
	}

	public List<Huesped> traerTodosHuespedes() {
		em.getTransaction().begin();
		
		List<Huesped> listaHuesped = huespedDao.consultarTodos();
		
		em.getTransaction().commit();
		return listaHuesped;
	}

	public Reserva traerReservaPorId(int numeroReserva) {
		em.getTransaction().begin();
		
		Reserva reserva = reservaDao.consultarReservaPorId(numeroReserva);
		
		em.getTransaction().commit();
		
		return reserva;
	}


	public Huesped traerHuespedPorId(int numeroReserva) {
		return null;
	}

	public boolean actualizarReservaHuesped(Reserva reserva, Huesped huesped) {
		
		try {
			em.getTransaction().begin();
			
			reservaDao.actualizar(reserva);
			huespedDao.actualizar(huesped);
			
			em.getTransaction().commit();
			
			return true;
		}catch(Exception e){
			return false;
		}


	}

	public void borrarReserva(int numeroReserva) {
		Reserva reserva = traerReservaPorId(numeroReserva);
		Huesped huesped = reserva.getHuesped();
		
		try {
			em.getTransaction().begin();
			reservaDao.borrarReserva(reserva);
			huespedDao.borrarHuesped(huesped);
			
			em.getTransaction().commit();

		}catch(Exception e){

		}		
	}


}
