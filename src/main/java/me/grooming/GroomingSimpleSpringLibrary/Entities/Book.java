package me.grooming.GroomingSimpleSpringLibrary.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import me.grooming.GroomingSimpleSpringLibrary.Enums.BookStatus;

/**
 * This Book is how the Book will be stored in the Library Repository.
 * Therefore, any queries for Library Repository will be through this Book, or
 * this is how Books will be stored in the Inventory, or for Developers to view
 * in DataBase.
 * 
 * @author Siddharth Jagota
 * 
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "libraryCode")
	private Long libraryCode;

	@Column(name = "bookISBN", unique = true, nullable = false)
	private Long bookISBN;

	@Column(name = "bookName", nullable = false)
	private String bookName;

	@Column(name = "bookSubjectOrGenre", nullable = false)
	private String bookSubjectOrGenre;

	@Column(name = "bookStatus", nullable = false)
	private BookStatus bookStatus;

}