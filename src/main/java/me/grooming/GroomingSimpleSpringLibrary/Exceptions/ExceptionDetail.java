package me.grooming.GroomingSimpleSpringLibrary.Exceptions;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Exception Detail as an Object to be returned as HTTP response with proper
 * JSON format.
 * 
 * @author Siddharth Jagota
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionDetail {

	private String message;
	private String detailedNotes;
	private Date date;

}