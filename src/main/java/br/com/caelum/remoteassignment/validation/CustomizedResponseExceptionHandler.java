package br.com.caelum.remoteassignment.validation;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Classe criada para customizar mensagens de erro
 * na API REST.
 * @author Guilherme Tadeu
 * @version 1.0.0
 */
@RestController
@ControllerAdvice
public class CustomizedResponseExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Método criado para capturar mensagem de erro
	 * gerada pelo Bean Validation.
	 * @author Guilherme Tadeu
	 * @version 1.0.0
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return ResponseEntity.badRequest()
				.body(ex.getBindingResult()
						.getAllErrors()
						.get(0)
						.getDefaultMessage());
	}
}
