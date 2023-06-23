package me.grooming.GroomingSimpleSpringLibrary.Mappers;

import java.lang.reflect.Type;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;

import org.springframework.stereotype.Component;

import me.grooming.GroomingSimpleSpringLibrary.Entities.Book;
import me.grooming.GroomingSimpleSpringLibrary.Entities.HardCoverBook;

/**
 * Mapper which uses Model mapper to map HardCoverBook (Client-Side
 * Communication Medium) to Book (Server/Repository-Side Communication Medium)
 * and vice-versa. This is essential for completing the missing link between the
 * End-User and the DataBase Server/Repository.
 * 
 * @author Siddharth Jagota
 * 
 */
@Component
public class BookHardCoverBookMapper {

	ModelMapper mapper = new ModelMapper();

	public BookHardCoverBookMapper() {

		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

	}

	public Book mapHardCoverBookToBook(HardCoverBook givenHardCoverBook) {

		mapper.typeMap(HardCoverBook.class, Book.class);

		return mapper.map(givenHardCoverBook, Book.class);

	}

	public HardCoverBook mapBookToHardCoverBook(Book givenBook) {

		mapper.typeMap(Book.class, HardCoverBook.class);

		return mapper.map(givenBook, HardCoverBook.class);

	}

	public List<Book> mapListOfHardCoverBooksToListOfBooks(List<HardCoverBook> givenListOfHardCoverBooks) {

		Type listTypeOfBooks = new TypeToken<List<Book>>() {
		}.getType();

		return mapper.map(givenListOfHardCoverBooks, listTypeOfBooks);

	}

	public List<HardCoverBook> mapListOfBooksToListOfHardCoverBooks(List<Book> givenListOfBooks) {

		Type listTypeOfHardCoverBooks = new TypeToken<List<HardCoverBook>>() {
		}.getType();

		return mapper.map(givenListOfBooks, listTypeOfHardCoverBooks);

	}

}