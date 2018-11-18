package impl.miw.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes({"loginCounter"})
@Controller
public class WelcomeController {

	/*
	 * Setting / as request mapping url we are setting the default controller for the application.
	 */
	@RequestMapping("/")
	public String welcome()
	{
		System.out.println("Executing Welcome controller");
		return "redirect:index";
	}


@ModelAttribute("loginCounter")
public LoginCounter getLoginCounter()
{
	System.out.println("creando modelo contador");
return new LoginCounter();
}

}

