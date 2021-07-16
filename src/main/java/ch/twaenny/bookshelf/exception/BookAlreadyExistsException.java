package ch.twaenny.bookshelf.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Book already exists")
public class BookAlreadyExistsException extends RuntimeException {
	public BookAlreadyExistsException() {
		super("", null, true, false);
	}
}
