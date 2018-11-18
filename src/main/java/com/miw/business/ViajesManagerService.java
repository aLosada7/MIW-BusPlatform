package com.miw.business;

import java.util.Map;
import java.util.Vector;
import com.miw.model.BusquedaData;
import com.miw.model.CancelacionData;
import com.miw.model.ReservaData;
import com.miw.model.Viaje;

public interface ViajesManagerService {
	public Vector<Viaje> getViajes() throws Exception;

	public void cancelarViaje(CancelacionData cancelacion) throws Exception;

	public Vector<Viaje> getViajesPorFiltroIda(BusquedaData busqueda) throws Exception;
	
	public Vector<Viaje> getViajesPorFiltroVuelta(BusquedaData busqueda) throws Exception;

	public void reservarViaje(ReservaData reserva) throws Exception;

	public Map<Integer, String> getDestinosMasPopulares() throws Exception;

	public String getImagenDestino(String destino) throws Exception;

	public Viaje getViaje(int identificadorViaje) throws Exception;
}
