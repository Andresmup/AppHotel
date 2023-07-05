package com.alura.logica.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.alura.logica.modelo.Reserva;

public class ReservaDao {
	private EntityManager em;

	public ReservaDao(EntityManager em) {
		this.em = em;
	}

	public void guardar(Reserva reserva) {
		this.em.persist(reserva);
	}
	
	public void actualizar(Reserva reserva) {
		this.em.merge(reserva);
	}

	public Reserva consultarReservaPorId(int numeroReserva) {
		return em.find(Reserva.class, numeroReserva);
	}
	
	public List<Reserva> consultarTodosConParametroDeHuesped(String parametroBusqueda) {
	    String jpql = "SELECT r FROM Reserva r JOIN r.huesped h WHERE h.nombre = :parametroBusqueda OR h.apellido = :parametroBusqueda OR h.telefono = :parametroBusqueda";
	    return em.createQuery(jpql, Reserva.class).setParameter("parametroBusqueda", parametroBusqueda).getResultList();

	}

	public List<Reserva> consultarTodos() {
		String jpql = "SELECT R FROM Reserva AS R";
		return em.createQuery(jpql, Reserva.class).getResultList();
	}

	public void borrarReserva(Reserva reserva) {
		this.em.remove(reserva);
		
	}


}
