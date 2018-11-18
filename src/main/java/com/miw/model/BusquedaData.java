package com.miw.model;

import java.sql.Date;

public class BusquedaData {

	private int id;
	private String lugarSalida;
	private String lugarLlegada;
	private Date fechaIda;
	private String idaFechaCalendar;
	private String vueltaFechaCalendar="";
	private Date fechaVuelta;
	private int numViajeros=1;
	
	
	
	
	public String getLugarSalida() {
		return lugarSalida;
	}
	public void setLugarSalida(String lugarSalida) {
		this.lugarSalida = lugarSalida;
	}
	public String getLugarLlegada() {
		return lugarLlegada;
	}
	public void setLugarLlegada(String lugarLlegada) {
		this.lugarLlegada = lugarLlegada;
	}
	public Date getFechaIda() {
		return fechaIda;
	}
	public void setFechaIda(Date fechaIda) {
		this.fechaIda = fechaIda;
	}
	public Date getFechaVuelta() {
		return fechaVuelta;
	}
	public void setFechaVuelta(Date fechaVuelta) {
		this.fechaVuelta = fechaVuelta;
	}
	public int getNumViajeros() {
		return numViajeros;
	}
	public void setNumViajeros(int numViajeros) {
		this.numViajeros = numViajeros;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdaFechaCalendar() {
		return idaFechaCalendar;
	}
	public void setIdaFechaCalendar(String idaFechaCalendar) {
		this.idaFechaCalendar = idaFechaCalendar;
	}
	public String getVueltaFechaCalendar() {
		return vueltaFechaCalendar;
	}
	public void setVueltaFechaCalendar(String vueltaFechaCalendar) {
		this.vueltaFechaCalendar = vueltaFechaCalendar;
	}
	
	
}
