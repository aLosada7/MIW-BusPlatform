package impl.miw.presentation.index;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.miw.business.ViajesManagerService;
import com.miw.model.BusquedaData;
import com.miw.model.Viaje;

import impl.miw.presentation.LoginCounter;

@Controller
@RequestMapping("index")
public class IndexController {
	
	@Autowired
	private ViajesManagerService viajesManagerService;
	
	public void setViajesManagerService(ViajesManagerService viajesManagerService) {
		this.viajesManagerService = viajesManagerService;
	}

	@RequestMapping (method=RequestMethod.GET)
	public String getForm(@ModelAttribute("loginCounter")
	LoginCounter loginCounter)
	{
		System.out.println("Preparing the model for Principal Screen");
		loginCounter.inc();
		//We could prepare the model here instead of using  @ModelAttribute
		return "index";
	}
	
	
	@RequestMapping (method=RequestMethod.POST)
	public String processForm(@ModelAttribute ("index") BusquedaData busqueda, Model model, RedirectAttributes redirectAttributes) throws ParseException
	{
		if(busqueda.getLugarSalida() != null && busqueda.getLugarLlegada() !=null && busqueda.getNumViajeros()>=1) {
		System.out.println("Acceso a la búsqueda de viajes");
		System.out.println(busqueda.getIdaFechaCalendar());
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy"); // New Pattern
        java.util.Date date = sdf1.parse(busqueda.getIdaFechaCalendar()); // Returns a Date format object with the pattern
        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
        System.out.println(sqlStartDate);
        busqueda.setFechaIda(sqlStartDate);
        if(busqueda.getVueltaFechaCalendar() != "") {
	        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy"); // New Pattern
	        java.util.Date date2 = sdf2.parse(busqueda.getVueltaFechaCalendar()); // Returns a Date format object with the pattern
	        java.sql.Date sqlStartDate2 = new java.sql.Date(date2.getTime());
	        System.out.println(sqlStartDate2);
	        busqueda.setFechaVuelta(sqlStartDate2);
			
        }
        redirectAttributes.addFlashAttribute("index", busqueda);
		return "redirect:eleccionBus";
		} else {
			return "index";
		}
	}
	
	@ModelAttribute("index")
	public BusquedaData prepareModel(Model model) throws Exception
	{
		Vector<Viaje> viajes = viajesManagerService.getViajes();
		model.addAttribute("viajeslist",
				viajes);
		model.addAttribute("destinospopulares",viajesManagerService.getDestinosMasPopulares());
		System.out.println("Invoking prepareModel()");
		return new BusquedaData();
	}

	
	
}
