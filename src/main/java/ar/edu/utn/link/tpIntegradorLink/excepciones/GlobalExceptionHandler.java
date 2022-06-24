package ar.edu.utn.link.tpIntegradorLink.excepciones;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String mensaje(Exception ex) {
		return ex.getMessage();
	}
}
