package model;

public class Library {
	private Book firstBook;
	
	public Library() {
	}
	
	public void addBook(String n, String c, String a) {
		Book newBook = new Book(n,c,a);
		
		if(firstBook==null) {
			firstBook = newBook;
		}else {
			Book current = firstBook;
			while(current.getNextBook()!=null) {
				current = current.getNextBook();
			}
			current.setNextBook(newBook);
		}
	}
	
	public Book searchBook(String c) {
		Book b = null;
		
		Book current = firstBook;
		while(current!=null && b==null) {
			if(c.equals(current.getCode())) {
				b = current;
			}
			current = current.getNextBook();
		}
		
		return b;
	}
	
	public Book removeBook(String c) {
		Book b = null;
		
		if(firstBook!=null) {
			if(c.equals(firstBook.getCode())) {
				b = firstBook;
				firstBook = firstBook.getNextBook();
			}else {
				Book current = firstBook;
				while(current.getNextBook()!=null
						&& !c.equals(current.getNextBook().getCode())) {
					current = current.getNextBook();
				}
				
				if(current.getNextBook()!=null) { //current is before
					b = current.getNextBook();
					current.setNextBook(current.getNextBook().getNextBook());
				}
			}
		}
		
		return b;
	}
}
