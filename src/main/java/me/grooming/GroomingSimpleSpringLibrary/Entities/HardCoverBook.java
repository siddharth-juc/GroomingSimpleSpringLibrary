package me.grooming.GroomingSimpleSpringLibrary.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import me.grooming.GroomingSimpleSpringLibrary.Enums.BookStatus;

/**
 * HardCoverBook is how Book will be received from Client/Customer of our
 * Library. Hence, for Client, books are readable in this form of Hard Cover
 * Book, or this is how the End-User will view in a Library Card.
 * 
 * @author Siddharth Jagota
 * 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HardCoverBook {

	@JsonProperty("book_ISBN")
	private Long bookISBN;

	@JsonProperty("book_name")
	private String bookName;

	@JsonProperty("book_subject_or_genre")
	private String bookSubjectOrGenre;

	@JsonProperty("book_status")
	private BookStatus bookStatus;

}