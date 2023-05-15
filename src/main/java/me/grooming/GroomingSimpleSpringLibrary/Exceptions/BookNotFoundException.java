package me.grooming.GroomingSimpleSpringLibrary.Exceptions;

/**
 * An Exception that is thrown when trying to update (or get through ISBN) a
 * Book that isn't present in the Library.
 * 
 * @author Siddharth Jagota
 * 
 */
public class BookNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 965402949031750106L;

	public BookNotFoundException(String exceptionMessage) {

		super(exceptionMessage);

	}

}