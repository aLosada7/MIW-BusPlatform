package impl.miw.presentation.reservarViaje;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.miw.model.ReservaData;

public class ReservaValidator implements Validator{
	public boolean supports(Class clazz) {
		return ReservaData.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		ReservaData login = (ReservaData) target;
		if(login.getEmail().indexOf("@") == -1) {
			errors.rejectValue("email", "Invalido", "No es un e-mail correcto");
		}
		
	}
}
