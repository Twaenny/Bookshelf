package ch.twaenny.bookshelf.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Bad arguments")
public class InvalidArgumentException extends RuntimeException {
	public InvalidArgumentException() {
		super("", null, true, false);
	}
	
}
