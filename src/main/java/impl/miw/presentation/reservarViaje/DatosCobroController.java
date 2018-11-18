package impl.miw.presentation.reservarViaje;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
@RequestMapping("datosCobro")
public class DatosCobroController {
	
	private int identificadorViajeIda;
	private int identificadorViajeVuelta;
	private int numViajeros;
	private boolean extraBicicleta;
	private boolean extraMascota;
	private boolean extraSurf;
	private boolean extraSkis;
	private boolean seguro;
	
	@Autowired
	private ViajesManagerService viajesManagerService;
	
	public void setViajesManagerService(ViajesManagerService viajesManagerService) {
		this.viajesManagerService = viajesManagerService;
	}

	@RequestMapping (method=RequestMethod.GET)
	public String getForm(@ModelAttribute("eleccionExtras") ReservaData reserva, Model model, @ModelAttribute("loginCounter")
	LoginCounter loginCounter)
	{
		loginCounter.inc();
		System.out.println("Preparing the model for Cobro Election Screen");
		//We could prepare the model here instead of using  @ModelAttribute
		identificadorViajeIda=reserva.getIdentificadorViajeIda();
		identificadorViajeVuelta=reserva.getIdentificadorViajeVuelta();
		numViajeros=reserva.getNumViajeros();
		extraBicicleta=reserva.isExtraBicicleta();
		extraMascota=reserva.isExtraMascota();
		extraSurf=reserva.isExtraSurf();
		extraSkis=reserva.isExtraSkis();
		seguro=reserva.isSeguro();
		return "datosCobro";
	}
	
	
	@RequestMapping (method=RequestMethod.POST)
	public String processForm(@ModelAttribute ("datosCobro") ReservaData reserva, BindingResult result, Model model, RedirectAttributes redirectAttributes) throws Exception
	{
		reserva.setIdentificadorViajeIda(identificadorViajeIda);
		reserva.setIdentificadorViajeVuelta(identificadorViajeVuelta);
		reserva.setNumViajeros(numViajeros);
		reserva.setExtraBicicleta(extraBicicleta);
		reserva.setExtraMascota(extraMascota);
		reserva.setExtraSurf(extraSurf);
		reserva.setExtraSkis(extraSkis);
		reserva.setSeguro(seguro);
		System.out.println("Lo tenemos todo. "+reserva);
		ReservaValidator userValidator= new ReservaValidator ();
		userValidator.validate(reserva, result);
		viajesManagerService.reservarViaje(reserva);
		model.addAttribute("message", "Reserva realizada");
		redirectAttributes.addFlashAttribute("datosCobro", reserva);
		return "redirect:resumenReserva";
	}
	
	@ModelAttribute("datosCobro")
	public ReservaData prepareModel(Model model) throws Exception
	{
		System.out.println("Invoking prepareModel()");
		
		return new ReservaData();
	}

	
	
}
