package com.miw.model;

public class CancelacionData {
	private String identificadorReserva;
	private String email;
	private boolean confirmarCancelacion;
	
	public String getIdentificadorReserva() {
		return identificadorReserva;
	}
	public void setIdentificadorReserva(String identificadorReserva) {
		this.identificadorReserva = identificadorReserva;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isConfirmarCancelacion() {
		return confirmarCancelacion;
	}
	public void setConfirmarCancelacion(boolean confirmarCancelacion) {
		this.confirmarCancelacion = confirmarCancelacion;
	}
	
	
	
}
