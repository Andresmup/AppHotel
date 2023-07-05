package com.alura.logica.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idReserva;
	private Date fechaIngreso;
	private Date fechaSalida;
	private double valorReserva;
	private String medioPago;
	
	@OneToOne
	private Huesped huesped;
	
	public Reserva() {
	}
	

	public Reserva(Integer id, Date fechaIngreso, Date fechaSalida, double valorReserva, String medioPago, Huesped huesped) {
		this.idReserva = id;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.valorReserva = valorReserva;
		this.medioPago = medioPago;
		this.huesped = huesped;
	}


	public Integer getId() {
		return idReserva;
	}
	public void setId(Integer id) {
		this.idReserva = id;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public double getValorReserva() {
		return valorReserva;
	}
	public void setValorReserva(double valorReserva) {
		this.valorReserva = valorReserva;
	}
	public String getMedioPago() {
		return medioPago;
	}
	public void setMedioPago(String medioPago) {
		this.medioPago = medioPago;
	}
	public Integer getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}
	public Huesped getHuesped() {
		return huesped;
	}
	public void setHuesped(Huesped huesped) {
		this.huesped = huesped;
	}


	
	

	
	
}
