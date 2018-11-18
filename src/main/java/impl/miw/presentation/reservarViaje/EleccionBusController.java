package impl.miw.presentation.reservarViaje;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.miw.business.BookManagerService;
import com.miw.business.ViajesManagerService;
import com.miw.model.BusquedaData;
import com.miw.model.ReservaData;

import impl.miw.presentation.LoginCounter;


@Controller
@RequestMapping("eleccionBus")
public class EleccionBusController {
	
	private int numViajeros;
	
	@Autowired
	private ViajesManagerService viajesManagerService;
	
	public void setViajesManagerService(ViajesManagerService viajesManagerService) {
		this.viajesManagerService = viajesManagerService;
	}

	@RequestMapping (method=RequestMethod.GET)
	public String getForm(@ModelAttribute ("index") BusquedaData busqueda,Model model, @ModelAttribute("loginCounter")
	LoginCounter loginCounter) throws Exception
	{
		
		loginCounter.inc();
		System.out.println("Preparing the model for Bus Election Screen");
		//We could prepare the model here instead of using  @ModelAttribute
		System.out.println(busqueda.getLugarSalida()+" "+busqueda.getLugarLlegada()+" "+busqueda.getFechaIda()+" "+
		busqueda.getFechaVuelta()+" "+busqueda.getNumViajeros());
		numViajeros=busqueda.getNumViajeros();
		model.addAttribute("viajesporfiltrolistida",
					viajesManagerService.getViajesPorFiltroIda(busqueda));
		model.addAttribute("imagenDestinoIda",
				viajesManagerService.getImagenDestino(busqueda.getLugarLlegada()));
		if(busqueda.getVueltaFechaCalendar() != "") {
			model.addAttribute("viajesporfiltrolistvuelta",
					viajesManagerService.getViajesPorFiltroVuelta(busqueda));
			model.addAttribute("imagenDestinoVuelta",
					viajesManagerService.getImagenDestino(busqueda.getLugarLlegada()));
		}
		return "eleccionBus";
	}
	
	
	@RequestMapping (method=RequestMethod.POST)
	public String processForm(@ModelAttribute ("eleccionBus") ReservaData reserva, Model model, RedirectAttributes redirectAttributes)
	{
		reserva.setNumViajeros(numViajeros);
		redirectAttributes.addFlashAttribute("eleccionBus", reserva);
		System.out.println("Accesso a la configuración de extras y seguros");
		return "redirect:eleccionExtras";
	}
	
	@ModelAttribute("eleccionBus")
	public ReservaData prepareModel(Model model)
	{
		System.out.println("Invoking prepareModeliiiiiiii()");
		return new ReservaData();
	}

	
	
}
