package com.exceptions;

class DatabaseException extends Exception{
	public DatabaseException(String message,Throwable e) {
		super(message,e);
	}
}

public class ExceptionChaining {
	
	public static void main(String[] args) {
		try {
			connectToDB();
		} catch (DatabaseException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void connectToDB() throws DatabaseException {
		try {
			throw new NullPointerException("DB details are null");
		}catch (NullPointerException e) {
			throw new DatabaseException("Failed to connect to database", e);
		}
	}
}
