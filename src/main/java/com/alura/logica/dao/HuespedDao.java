package com.alura.logica.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.alura.logica.modelo.Huesped;
import com.alura.logica.modelo.Reserva;

public class HuespedDao {
	private EntityManager em;

	public HuespedDao(EntityManager em) {
		this.em = em;
	}

	public void guardar(Huesped huesped) {
		this.em.persist(huesped);
	}
	
	public void actualizar(Huesped huesped) {
		this.em.merge(huesped);
	}

	public List<Huesped> consultarTodosConParametro(String parametroBusqueda) {
		String jpql = "SELECT h FROM Huesped h WHERE h.nombre =: parametroBusqueda OR h.apellido =: parametroBusqueda OR h.telefono =: parametroBusqueda";
		return em.createQuery(jpql,Huesped.class).setParameter("parametroBusqueda", parametroBusqueda).getResultList();
	}

	public List<Huesped> consultarTodos() {
		String jpql = "SELECT H FROM Huesped AS H";
		return em.createQuery(jpql, Huesped.class).getResultList();
	}

	public void borrarHuesped(Huesped huesped) {
		this.em.remove(huesped);		
	}
}
