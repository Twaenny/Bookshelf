package ch.twaenny.bookshelf.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ch.twaenny.bookshelf.model.AppUser;
import ch.twaenny.bookshelf.model.Book;
import ch.twaenny.bookshelf.model.BookImpl;
import ch.twaenny.bookshelf.model.Shelf;

public interface BookRepository extends CrudRepository<BookImpl, Long> {

	default Book insertBook(String name, Integer isbn, AppUser loanee, Shelf shelf) {
		return save(new BookImpl(null, name, isbn, loanee, shelf));
	}
	
	@Query
	Optional<Book> findByName(String name);
}
