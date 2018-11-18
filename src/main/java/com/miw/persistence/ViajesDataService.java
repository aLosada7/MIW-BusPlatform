package com.miw.persistence;

import java.util.List;
import java.util.Map;
import java.util.Vector;
import com.miw.model.BusquedaData;
import com.miw.model.CancelacionData;
import com.miw.model.Destino;
import com.miw.model.Viaje;

public interface ViajesDataService {
	public Vector<Viaje> getViajes() throws Exception;

	public String getImagenDestino(String destino) throws Exception;

	public Vector<Destino> getDestinosMasPopulares() throws Exception;

	public Viaje getViaje(int identificadorViaje) throws Exception;
}
