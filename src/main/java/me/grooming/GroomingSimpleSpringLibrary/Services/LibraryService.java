package me.grooming.GroomingSimpleSpringLibrary.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.grooming.GroomingSimpleSpringLibrary.Entities.Book;
import me.grooming.GroomingSimpleSpringLibrary.Repositories.LibraryRepository;

/**
 * This is the Library Service which will interact with the Repository to
 * process Queries passed by the Library Controller along with the Book passed
 * as Sever/Repository-side format by the Library Controller itself using the
 * BookHardCoverBookMapper.
 * 
 * @author Siddharth Jagota
 * 
 */
@Service
public class LibraryService {

	@Autowired
	private LibraryRepository libraryRepository;

	public Book addNewBookToLibrary(Book newBook) {

		Optional<Book> bookInLibrary = libraryRepository.findById(newBook.getBookISBN());
		return bookInLibrary.isPresent() ? null : libraryRepository.save(newBook);

	}

	public List<Book> listAllBooksByBookSubjectOrGenre(String givenSubjectOrGenre) {

		return libraryRepository.findByBookSubjectOrGenre(givenSubjectOrGenre);

	}

	public List<Book> listAllBooksOnShelf() {

		return libraryRepository.findAllBooksOnShelf();

	}

	public Book findBookByISBN(Long givenISBN) {

		Optional<Book> requiredBook = libraryRepository.findById(givenISBN);
		return requiredBook.isPresent() ? requiredBook.get() : null;

	}

	public Book updateBook(Book updatedBook) {

		Optional<Book> bookInLibrary = libraryRepository.findById(updatedBook.getBookISBN());
		return bookInLibrary.isPresent() ? libraryRepository.save(updatedBook) : null;

	}

	public void deleteBookByISBN(Long givenISBN) {

		libraryRepository.deleteById(givenISBN);

	}

}