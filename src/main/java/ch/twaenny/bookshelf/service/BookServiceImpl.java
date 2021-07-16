package ch.twaenny.bookshelf.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.twaenny.bookshelf.exception.BookAlreadyExistsException;
import ch.twaenny.bookshelf.exception.InvalidArgumentException;
import ch.twaenny.bookshelf.model.AppUser;
import ch.twaenny.bookshelf.model.Book;
import ch.twaenny.bookshelf.model.Shelf;
import ch.twaenny.bookshelf.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepository repo;
	

	@Override
	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();
		
		for (var book : repo.findAll()) {
			books.add(book);
		}
		return books;
	}


	@Override
	public Book addBook(String name, Integer isbn, AppUser loanee, Shelf shelf) {
		if(name == null || isbn == null) {
			throw new InvalidArgumentException();
		}
		if(repo.findByName(name).isPresent()) {
			throw new BookAlreadyExistsException();
		}
		
		return repo.insertBook(name, isbn, loanee, shelf);
	}



	
	
}
