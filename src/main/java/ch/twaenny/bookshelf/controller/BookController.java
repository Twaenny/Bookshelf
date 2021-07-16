package ch.twaenny.bookshelf.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.twaenny.bookshelf.model.AppUser;
import ch.twaenny.bookshelf.model.Shelf;
import ch.twaenny.bookshelf.service.BookService;
import ch.twaenny.bookshelf.service.ShelfService;
import ch.twaenny.bookshelf.service.UserService;

@RestController()
@RequestMapping("rest/v1/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;
	@Autowired
	private ShelfService shelfService;
	
	@GetMapping("")
	List<BookDto> getAllAutos() {
		return bookService.getAllBooks()
			.stream()
			.map(book -> new BookDto(book))
			.collect(Collectors.toList());
	}
	
	@PostMapping("")
	BookDto insertBook(@RequestBody  BookInputDto bookInput) {
		AppUser loanee = userService.getUserById(bookInput.loaneeId);
		Shelf shelf = shelfService.getShelfById(bookInput.shelfId);
		return new BookDto(
				bookService.addBook(
						bookInput.name, 
						bookInput.isbn, 
						loanee,
						shelf)
			);
	}
}

