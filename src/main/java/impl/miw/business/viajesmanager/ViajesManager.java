package impl.miw.business.viajesmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;

import com.miw.business.ViajesManagerService;
import com.miw.model.Book;
import com.miw.model.BusquedaData;
import com.miw.model.CancelacionData;
import com.miw.model.Destino;
import com.miw.model.ReservaData;
import com.miw.model.Viaje;
import com.miw.persistence.CancelarViajeDataService;
import com.miw.persistence.ReservarViajeDataService;
import com.miw.persistence.ViajesDataService;
import com.miw.persistence.ViajesPorFiltroDataService;

public class ViajesManager implements ViajesManagerService{
	
	@Autowired
	private ViajesDataService viajesDataService = null;
	
	@Autowired
	private ViajesPorFiltroDataService viajesPorFiltroDataService = null;
	
	@Autowired
	private ReservarViajeDataService reservarViajeDataService = null;
	
	@Autowired
	private CancelarViajeDataService cancelarViajeDataService = null;
	
	public void setViajesDataService(ViajesDataService viajesDataService) {
		System.out.println("Setting viajesDataService bean");
		this.viajesDataService = viajesDataService;
	}
	
	public void setCancelarViajeDataService(CancelarViajeDataService cancelarViajeDataService) {
		System.out.println("Setting cancelarViajeDataService bean");
		this.cancelarViajeDataService = cancelarViajeDataService;
	}
	
	

	public Vector<Viaje> getViajes() throws Exception {
		Vector<Viaje> viajes = viajesDataService.getViajes();
		return viajes;
	}
	
	public void cancelarViaje(CancelacionData cancelacion) throws Exception {
		System.out.println("hola"+cancelacion.getIdentificadorReserva());
		cancelarViajeDataService.cancelarViaje(cancelacion);
		return;
	}

	public Vector<Viaje> getViajesPorFiltroIda(BusquedaData busqueda) throws Exception {
		// TODO Auto-generated method stub
		Vector<Viaje> viajesPorFiltro = viajesPorFiltroDataService.getViajesPorFiltroIda(busqueda);
		return viajesPorFiltro;
	}
	
	public Vector<Viaje> getViajesPorFiltroVuelta(BusquedaData busqueda) throws Exception {
		// TODO Auto-generated method stub
		Vector<Viaje> viajesPorFiltro = viajesPorFiltroDataService.getViajesPorFiltroVuelta(busqueda);
		return viajesPorFiltro;
	}

	public void reservarViaje(ReservaData reserva) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("hola"+reserva.getNombre());
		reservarViajeDataService.reservarViaje(reserva);
		return;
	}

	public Map<Integer, String> getDestinosMasPopulares() throws Exception {
		// TODO Auto-generated method stub
		Map<Integer, String> mapDestinosPopulares = new HashMap<Integer, String>();
		Vector <Destino> destinos= new Vector<Destino>();
		destinos = viajesDataService.getDestinosMasPopulares();
		int i=1;
		for (Destino destino : destinos) {
			if(i<=3) {
				mapDestinosPopulares.put(i, destino.getDestino());
				i++;
			}
		}
		Iterator<Integer> it = mapDestinosPopulares.keySet().iterator();
		while(it.hasNext()){
		  Integer key = it.next();
		  System.out.println("Clave: " + key + " -> Valor: " + mapDestinosPopulares.get(key));
		}


		return mapDestinosPopulares;
	}

	public String getImagenDestino(String destino) throws Exception {
		// TODO Auto-generated method stub
		String imagenDestino=viajesDataService.getImagenDestino(destino);
		return imagenDestino;
	}

	public Viaje getViaje(int identificadorViaje) throws Exception {
		// TODO Auto-generated method stub
		return viajesDataService.getViaje(identificadorViaje);
	}

}
