package impl.miw.presentation.cancelarViaje;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.miw.business.ViajesManagerService;
import com.miw.model.BusquedaData;
import com.miw.model.CancelacionData;

@Controller
@RequestMapping("cancelarViaje")
public class CancelarViajeController {
	
	@Autowired
	private ViajesManagerService viajesManagerService;
	
	public void setViajesManagerService(ViajesManagerService viajesManagerService) {
		this.viajesManagerService = viajesManagerService;
	}

	@RequestMapping (method=RequestMethod.GET)
	public String getForm()
	{
		System.out.println("Preparing the model for Cancelation Screen");
		//We could prepare the model here instead of using  @ModelAttribute
		return "cancelarViaje";
	}
	
	
	@RequestMapping (method=RequestMethod.POST)
	public String processForm(@ModelAttribute ("cancelarViaje") CancelacionData cancelacion, Model model) throws Exception
	{
		System.out.println("Accesso a la cancelación de un viaje");
		if(cancelacion.isConfirmarCancelacion() == true) {
			System.out.println(cancelacion.getIdentificadorReserva() + " " + cancelacion.getEmail());
			viajesManagerService.cancelarViaje(cancelacion);
			return "redirect:index";
		}else{
			System.out.println("Sin aceptar confirmación");
			return "cancelarViaje";
		}
	}
	
	@ModelAttribute("cancelarViaje")
	public CancelacionData prepareModel()
	{
		System.out.println("Invoking prepareModel()");
		return new CancelacionData();
	}

	//<form:checkbox path="confirmacion" value="confirmacion"/>Confirmo que deseo cancelar este viaje
	
	
}
