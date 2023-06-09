package uea.chamado.resources.exceptions;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import uea.chamado.services.exceptions.PessoaNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<StandardError> noSuchElementException(NoSuchElementException e, HttpServletRequest request) {

		List<String> erros = Arrays
				.asList(messageSource.getMessage("mensagem.object.not_found", null, LocaleContextHolder.getLocale()));
		HttpStatus status = HttpStatus.NOT_FOUND;

		StandardError err = new StandardError(Instant.now(), status.value(), erros, e.getMessage(),
				request.getRequestURI());

		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(PessoaNotFoundException.class)
	public ResponseEntity<StandardError> pessoaNotFound(NoSuchElementException e, HttpServletRequest request) {

		List<String> erros = Arrays
				.asList(messageSource.getMessage("mensagem.pessoa.not_found", null, LocaleContextHolder.getLocale()));
		HttpStatus status = HttpStatus.NOT_FOUND;

		StandardError err = new StandardError(Instant.now(), status.value(), erros, "Pessoa não foi encontrada.",
				request.getRequestURI());

		return ResponseEntity.status(status).body(err);
	}
}
