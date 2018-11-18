package impl.miw.presentation.reservarViaje;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
@RequestMapping("resumenReserva")
public class ResumenReservaController {
	
	private String email;

	
	@Autowired
	private ViajesManagerService viajesManagerService;
	
	public void setViajesManagerService(ViajesManagerService viajesManagerService) {
		this.viajesManagerService = viajesManagerService;
	}

	@RequestMapping (method=RequestMethod.GET)
	public String getForm(@ModelAttribute("datosCobro") ReservaData reserva, Model model, @ModelAttribute("loginCounter")
	LoginCounter loginCounter) throws Exception
	{
		loginCounter.inc();
		System.out.println("Preparing the model for View Reservation Screen");
		email=reserva.getEmail();
		//We could prepare the model here instead of using  @ModelAttribute
		model.addAttribute("resumen", reserva);
		model.addAttribute("ida",viajesManagerService.getViaje(reserva.getIdentificadorViajeIda()));
		if(reserva.getIdentificadorViajeVuelta() != 0) {
			model.addAttribute("vuelta",viajesManagerService.getViaje(reserva.getIdentificadorViajeVuelta()));
		}
		return "resumenReserva";
	}
	
	private JavaMailSender mailSender;

    @RequestMapping(method = RequestMethod.POST)
    public String register(Model model) {
        
        String status = null;
        
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,true,"UTF-8");
            helper.setFrom("Administrator");
            helper.setTo(email);
            helper.setSubject("Booking confirmation - Confirmación de reserva");
            
            String text = "Thank you for your booking." ;
            
            helper.setText(text, true);
            mailSender.send(message);
            status = "Confirmation email is sent to your address (aldc30sc@gmail.com)";
        } catch (MessagingException e) {
            status = "There was an error in email sending. Please check your email address: aldc30sc@gmail.com";
        }

        model.addAttribute("message", status);
        return "resumenReserva";
    }

    @Autowired
    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

	
	
}
