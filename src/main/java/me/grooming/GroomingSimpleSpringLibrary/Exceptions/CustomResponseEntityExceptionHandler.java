package me.grooming.GroomingSimpleSpringLibrary.Exceptions;

import java.time.Instant;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.web.context.request.WebRequest;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * A Custom Exception handler that sends Library-specific Exceptions as HTTP
 * Responses.
 * 
 * @author Siddharth Jagota
 * 
 */
@RestControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<Object> handleBookNotFoundException(BookNotFoundException bookNotFoundException,
			WebRequest webRequest) {

		bookNotFoundException.printStackTrace();

		var exceptionDetail = new ExceptionDetail();

		String exceptionMessage = "Sorry! The Book you're looking for couldn't be found in the Library!!";

		exceptionDetail.setMessage(exceptionMessage);
		exceptionDetail.setDetailedNotes(webRequest.getDescription(false));
		exceptionDetail.setDate(Date.from(Instant.now()));

		return new ResponseEntity<Object>(exceptionDetail, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(BookAlreadyExistsException.class)
	public ResponseEntity<Object> handleBookAlreadyExistsException(
			BookAlreadyExistsException bookAlreadyExistsException, WebRequest webRequest) {

		bookAlreadyExistsException.printStackTrace();

		var exceptionDetail = new ExceptionDetail();

		String exceptionMessage = "Sorry! The Book you're trying to insert already exists in the Library!!";

		exceptionDetail.setMessage(exceptionMessage);
		exceptionDetail.setDetailedNotes(webRequest.getDescription(false));
		exceptionDetail.setDate(Date.from(Instant.now()));

		return new ResponseEntity<Object>(exceptionDetail, HttpStatus.FORBIDDEN);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleOtherInternalExceptions(Exception exception, WebRequest webRequest) {

		exception.printStackTrace();

		var exceptionDetail = new ExceptionDetail();

		String exceptionMessage = "Sorry! The Library seems to be working up!! "
				+ "Kindly wait while the Library tries to be up and running again!!";

		exceptionDetail.setMessage(exceptionMessage);
		exceptionDetail.setDetailedNotes(webRequest.getDescription(false));
		exceptionDetail.setDate(Date.from(Instant.now()));

		return new ResponseEntity<Object>(exceptionDetail, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}