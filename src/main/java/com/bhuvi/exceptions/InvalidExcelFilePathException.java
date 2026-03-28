package com.bhuvi.exceptions;

@SuppressWarnings("serial")
public class InvalidExcelFilePathException extends FrameworkExceptions{

	public InvalidExcelFilePathException(String message) {
		super(message);
	}
	
	public InvalidExcelFilePathException(String message, Throwable cause) {
		super(message, cause);
	}

}
