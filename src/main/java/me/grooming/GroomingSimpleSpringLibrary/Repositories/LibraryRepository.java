package me.grooming.GroomingSimpleSpringLibrary.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import me.grooming.GroomingSimpleSpringLibrary.Entities.Book;

/**
 * Repository being used by the Library. Here, the Repository works with the
 * DataBase hosted on Hibernate H2 In-Memory Server.
 * 
 * @author Siddharth Jagota
 * 
 */
@Repository
public interface LibraryRepository extends JpaRepository<Book, Long> {

	public List<Book> findByBookSubjectOrGenre(String givenSubjectOrGenre);

	@Query(value = "SELECT * FROM booksinventory AS books WHERE books.bookStatus = \'ON_SHELF\'")
	public List<Book> findAllBooksOnShelf();

}