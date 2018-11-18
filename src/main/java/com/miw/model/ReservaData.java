package com.miw.model;

/*INSERT INTO RESERVAS VALUES(1,1, 3,'true','false','false','false','true','Alvaro','Losada de Castro','DNI','71475433N','aldc30scgmail.com');
SELECT * FROM RESERVAS;*/
//INSERT INTO VIAJES (lugarsalida,lugarllegada,fechaviaje,horasalida,horallegada)VALUES('Oviedo','Madrid',DATE '2018-12-31','10:00','12:00');
public class ReservaData {
	
	private int idViaje;
	private int identificadorViajeIda;
	private int identificadorViajeVuelta=0;
	private int numViajeros;
	private boolean extraBicicleta;
	private boolean extraMascota;
	private boolean extraSurf;
	private boolean extraSkis;
	private boolean seguro;
	private String nombre;
	private String apellidos;
	private String tipoIdentificacion;
	private String identificacion;
	private String email;
	
	public int getIdentificadorViajeIda() {
		return identificadorViajeIda;
	}
	public void setIdentificadorViajeIda(int identificadorViajeIda) {
		this.identificadorViajeIda = identificadorViajeIda;
	}
	public int getIdentificadorViajeVuelta() {
		return identificadorViajeVuelta;
	}
	public void setIdentificadorViajeVuelta(int identificadorViajeVuelta) {
		this.identificadorViajeVuelta = identificadorViajeVuelta;
	}
	public int getNumViajeros() {
		return numViajeros;
	}
	public void setNumViajeros(int numViajeros) {
		this.numViajeros = numViajeros;
	}
	public boolean isExtraBicicleta() {
		return extraBicicleta;
	}
	public void setExtraBicicleta(boolean extraBicicleta) {
		this.extraBicicleta = extraBicicleta;
	}
	public boolean isExtraMascota() {
		return extraMascota;
	}
	public void setExtraMascota(boolean extraMascota) {
		this.extraMascota = extraMascota;
	}
	public boolean isExtraSurf() {
		return extraSurf;
	}
	public void setExtraSurf(boolean extraSurf) {
		this.extraSurf = extraSurf;
	}
	public boolean isExtraSkis() {
		return extraSkis;
	}
	public void setExtraSkis(boolean extraSkis) {
		this.extraSkis = extraSkis;
	}
	public boolean isSeguro() {
		return seguro;
	}
	public void setSeguro(boolean seguro) {
		this.seguro = seguro;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIdViaje() {
		return idViaje;
	}
	public void setIdViaje(int idViaje) {
		this.idViaje = idViaje;
	}
	
	
}
