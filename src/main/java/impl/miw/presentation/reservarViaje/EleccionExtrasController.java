package impl.miw.presentation.reservarViaje;


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
@RequestMapping("eleccionExtras")
public class EleccionExtrasController {

	private int identificadorViajeIda;
	private int identificadorViajeVuelta;
	private int numViajeros;
	
	@RequestMapping (method=RequestMethod.GET)
	public String getForm(@ModelAttribute("eleccionBus") ReservaData reserva, Model model, @ModelAttribute("loginCounter")
	LoginCounter loginCounter)
	{
		loginCounter.inc();
		System.out.println("Preparing the model for Extras Election Screen"+reserva.getIdentificadorViajeIda());
		model.addAttribute("idida",
				reserva.getIdentificadorViajeIda());
		identificadorViajeIda=reserva.getIdentificadorViajeIda();
		model.addAttribute("idvuelta",
				reserva.getIdentificadorViajeVuelta());
		identificadorViajeVuelta=reserva.getIdentificadorViajeVuelta();
		numViajeros=reserva.getNumViajeros();
		return "eleccionExtras";
	}
	
	
	@RequestMapping (method=RequestMethod.POST)
	public String processForm(@ModelAttribute("eleccionExtras") ReservaData reserva,Model model, RedirectAttributes redirectAttributes)
	{
		System.out.println(identificadorViajeIda + " " + identificadorViajeVuelta);
		reserva.setIdentificadorViajeIda(identificadorViajeIda);
		reserva.setIdentificadorViajeVuelta(identificadorViajeVuelta);
		reserva.setNumViajeros(numViajeros);
		System.out.println(reserva.getIdentificadorViajeIda()+" "+reserva.isExtraBicicleta());
		redirectAttributes.addFlashAttribute("eleccionExtras", reserva);
		System.out.println("Accesso al cobro");
		return "redirect:datosCobro";
	}
	
	@ModelAttribute("eleccionExtras")
	public ReservaData prepareModel(Model model) throws Exception
	{
		System.out.println("Invoking prepareModel()");
		return new ReservaData();
	}
	

	
	
}

