package com.alura.logica.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Huesped {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHuesped;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String nacionalidad;
	private String telefono;
	
	@OneToOne(mappedBy = "huesped")
	private Reserva reserva;
	
	public Huesped() {
		
	}
	public Huesped(Integer idHuesped, String nombre, String apellido, Date fechaNacimiento, String nacionalidad,
			String telefono, Reserva reserva) {
		this.idHuesped = idHuesped;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.reserva = reserva;
		this.telefono = telefono;
	}
	public Integer getIdHuesped() {
		return idHuesped;
	}
	public void setIdHuesped(Integer idHuesped) {
		this.idHuesped = idHuesped;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Reserva getReserva() {
		return reserva;
	}
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
	
	
	
}
