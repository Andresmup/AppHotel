package com.alura.prueba;

import java.util.List;

import javax.persistence.EntityManager;

import com.alura.logica.dao.UsuarioDao;
import com.alura.logica.modelo.Usuario;
import com.alura.persistencia.utils.JPAUtils;

public class PruebaConsultaUsuarios {
	public static void main(String[] args) {
		EntityManager em = JPAUtils.getEntityManager();
		UsuarioDao usuarioDao = new UsuarioDao(em);


		em.getTransaction().begin();
		List<Usuario> listaUsuario = usuarioDao.consultarPorNombre("admin");
		
		for(Usuario usuario: listaUsuario ) {
			System.out.println(usuario.getId());
			System.out.println(usuario.getUsuario());
			System.out.println(usuario.getClave());

		}
		
		em.getTransaction().commit();
		
	}
}
