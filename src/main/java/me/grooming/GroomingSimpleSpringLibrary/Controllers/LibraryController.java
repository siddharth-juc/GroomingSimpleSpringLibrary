package me.grooming.GroomingSimpleSpringLibrary.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.grooming.GroomingSimpleSpringLibrary.Entities.Book;
import me.grooming.GroomingSimpleSpringLibrary.Entities.HardCoverBook;

import me.grooming.GroomingSimpleSpringLibrary.Exceptions.BookAlreadyExistsException;
import me.grooming.GroomingSimpleSpringLibrary.Exceptions.BookNotFoundException;

import me.grooming.GroomingSimpleSpringLibrary.Mappers.BookHardCoverBookMapper;

import me.grooming.GroomingSimpleSpringLibrary.Services.LibraryService;

/**
 * This is the Library Controller that will interact with Clients and pass their
 * requests to Library Service for processing. This will also give the response
 * to the Clients as per the response received by Library Service. The API
 * Endpoints are exposed by this Library Controller to the End-User.
 * 
 * @author Siddharth Jagota
 * 
 */
@RestController
@RequestMapping("/library")
public class LibraryController {

	@Autowired
	private LibraryService libraryService;

	@Autowired
	private BookHardCoverBookMapper bookHardCoverBookMapper;

	@GetMapping("/")
	public String load() {

		return "Library System All Good . . . ";

	}

	@PostMapping("/book")
	public ResponseEntity<HardCoverBook> addNewBookToLibrary(@RequestBody HardCoverBook newBook)
			throws BookAlreadyExistsException {

		Book newBookAdded = libraryService.addNewBookToLibrary(bookHardCoverBookMapper.mapHardCoverBookToBook(newBook));

		if (newBookAdded == null)
			throw new BookAlreadyExistsException(newBook.toString());

		else
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(bookHardCoverBookMapper.mapBookToHardCoverBook(newBookAdded));

	}

	@GetMapping("/book/{givenSubjectOrGenre}")
	public ResponseEntity<List<HardCoverBook>> listAllBooksOfSubjectOrGenre(
			@PathVariable("givenSubjectOrGenre") String givenSubjectOrGenre) {

		return ResponseEntity.status(HttpStatus.FOUND)
				.body(bookHardCoverBookMapper.mapListOfBooksToListOfHardCoverBooks(
						libraryService.listAllBooksByBookSubjectOrGenre(givenSubjectOrGenre)));

	}

	@GetMapping("/book/{givenISBN}")
	public ResponseEntity<HardCoverBook> getBookThroughItsISBN(@PathVariable("givenISBN") Long givenISBN)
			throws BookNotFoundException {

		Book requiredBook = libraryService.findBookByISBN(givenISBN);

		if (requiredBook == null)
			throw new BookNotFoundException(givenISBN.toString());

		else
			return ResponseEntity.status(HttpStatus.FOUND)
					.body(bookHardCoverBookMapper.mapBookToHardCoverBook(requiredBook));

	}

	@GetMapping("/book/ON_SHELF")
	public ResponseEntity<List<HardCoverBook>> listAllBooksAvailableOnShelf() {

		return ResponseEntity.status(HttpStatus.FOUND).body(
				bookHardCoverBookMapper.mapListOfBooksToListOfHardCoverBooks(libraryService.listAllBooksOnShelf()));

	}

	@PutMapping("/book")
	public ResponseEntity<HardCoverBook> updateBook(@RequestBody HardCoverBook updatedBook)
			throws BookNotFoundException {

		Book updatedBookInLibrary = libraryService
				.updateBook(bookHardCoverBookMapper.mapHardCoverBookToBook(updatedBook));

		if (updatedBookInLibrary == null)
			throw new BookNotFoundException(updatedBook.toString());

		else
			return ResponseEntity.status(HttpStatus.ACCEPTED)
					.body(bookHardCoverBookMapper.mapBookToHardCoverBook(updatedBookInLibrary));

	}

	@DeleteMapping("/book/{givenISBN}")
	public ResponseEntity<String> deleteBookThroughISBN(@PathVariable("givenISBN") Long givenISBN) {

		libraryService.deleteBookByISBN(givenISBN);
		return ResponseEntity.status(HttpStatus.OK).body("Successfully Deleted!!");

	}

}