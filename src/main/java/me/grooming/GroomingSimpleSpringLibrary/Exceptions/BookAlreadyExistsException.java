package me.grooming.GroomingSimpleSpringLibrary.Exceptions;

/**
 * An Exception that is thrown when trying to insert a Book that is already
 * present in the Library.
 * 
 * @author Siddharth Jagota
 * 
 */
public class BookAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1666256155514343893L;

	public BookAlreadyExistsException(String exceptionMessage) {

		super(exceptionMessage);

	}

}