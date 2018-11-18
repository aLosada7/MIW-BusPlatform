package impl.miw.business.viajesmanager;

import java.util.Map;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;

import com.miw.business.ViajesManagerService;
import com.miw.model.BusquedaData;
import com.miw.model.CancelacionData;
import com.miw.model.ReservaData;
import com.miw.model.Viaje;
import com.miw.persistence.ViajesDataService;

import impl.miw.business.bookmanager.BookManager;


public class ViajesManagerEJBService implements ViajesManagerService{
	
	@Autowired
	private ViajesManager viajesManager=null;
	
	public void setViajesManager(ViajesManager viajesManager) {
		System.out.println("setting viajesManager reference");
		this.viajesManager = viajesManager;
	}

	public Vector<Viaje> getViajes() throws Exception {
		System.out.println("ViajesManagerEJBService.getViajes();");
		return viajesManager.getViajes();
	}
	
	public void cancelarViaje(CancelacionData cancelacion) throws Exception {
		System.out.println(cancelacion.getIdentificadorReserva());
		viajesManager.cancelarViaje(cancelacion);
	}

	public Vector<Viaje> getViajesPorFiltroIda(BusquedaData busqueda) throws Exception {
		// TODO Auto-generated method stub
		return viajesManager.getViajesPorFiltroIda(busqueda);
	}
	public Vector<Viaje> getViajesPorFiltroVuelta(BusquedaData busqueda) throws Exception {
		// TODO Auto-generated method stub
		return viajesManager.getViajesPorFiltroVuelta(busqueda);
	}

	public void reservarViaje(ReservaData reserva) throws Exception {
		// TODO Auto-generated method stub
		viajesManager.reservarViaje(reserva);
	}

	public Map<Integer, String> getDestinosMasPopulares() throws Exception {
		// TODO Auto-generated method stub
		return viajesManager.getDestinosMasPopulares();
	}

	public String getImagenDestino(String destino) throws Exception {
		// TODO Auto-generated method stub
		return viajesManager.getImagenDestino(destino);
	}

	public Viaje getViaje(int identificadorViaje) throws Exception {
		// TODO Auto-generated method stub
		return viajesManager.getViaje(identificadorViaje);
	}

}
