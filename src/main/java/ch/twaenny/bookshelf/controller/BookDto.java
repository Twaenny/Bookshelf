package ch.twaenny.bookshelf.controller;

import ch.twaenny.bookshelf.model.Book;

public class BookDto {
		public Long id;
		public final String name;
		public Integer isbn;
		
	public BookDto(Book book) {
		this.id = book.getID();
		this.name = book.getName();
		this.isbn = book.getIsbn();
		
	}
}
