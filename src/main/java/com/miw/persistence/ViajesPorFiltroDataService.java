package com.miw.persistence;

import java.util.Vector;

import com.miw.model.BusquedaData;
import com.miw.model.Viaje;

public interface ViajesPorFiltroDataService {
	public Vector<Viaje> getViajesPorFiltroIda(BusquedaData busqueda) throws Exception;
	
	public Vector<Viaje> getViajesPorFiltroVuelta(BusquedaData busqueda) throws Exception;
}
