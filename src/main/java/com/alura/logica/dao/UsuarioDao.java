package com.alura.logica.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.alura.logica.modelo.Usuario;

public class UsuarioDao {
	
	private EntityManager em;

	public UsuarioDao(EntityManager em) {
		this.em = em;
	}

	public List<Usuario> consultarPorNombre(String usuario) {
		String jpql = "SELECT U FROM Usuario AS U WHERE U.usuario=: usuario";
		return em.createQuery(jpql, Usuario.class).setParameter("usuario", usuario).getResultList();
	}

}
