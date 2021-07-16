package ch.twaenny.bookshelf.service;

import java.util.List;

import ch.twaenny.bookshelf.model.AppUser;
import ch.twaenny.bookshelf.model.Book;
import ch.twaenny.bookshelf.model.Shelf;

public interface BookService {

	List<Book> getAllBooks();
	
	Book addBook(String name, Integer isbn, AppUser loanee, Shelf shelf);
	
}
