package com.gft.es.prices.infrastructure.handler.exception;


import com.gft.es.prices.infrastructure.handler.exception.dto.RestError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import static org.springframework.data.crossstore.ChangeSetPersister.*;


@ControllerAdvice
@ResponseBody
public class PricesExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public RestError manageException(NotFoundException ex, WebRequest request) {
		return new RestError(HttpStatus.NOT_FOUND.value(), ex.getMessage(), ((ServletWebRequest) request).getRequest().getRequestURI());
	}

    @ExceptionHandler(InternalServerError.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public RestError manageException(InternalServerError ex, WebRequest request) {

		return new RestError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), ((ServletWebRequest) request).getRequest().getRequestURI());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public RestError manageException(MethodArgumentNotValidException ex, WebRequest request) {

		return new RestError(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), ((ServletWebRequest) request).getRequest().getRequestURI());
	}

}
