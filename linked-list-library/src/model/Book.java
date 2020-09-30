package model;

public class Book {
	private String name;
	private String code;
	private String author;
	
	private Book nextBook;
	
	public Book(String n, String c, String a) {
		name = n;
		code = c;
		author = a;
	}

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}

	public String getAuthor() {
		return author;
	}

	public Book getNextBook() {
		return nextBook;
	}
	
	public void setNextBook(Book nb) {
		nextBook = nb;
	}
}
