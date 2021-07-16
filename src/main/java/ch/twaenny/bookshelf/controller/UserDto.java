package ch.twaenny.bookshelf.controller;

import java.util.List;
import java.util.stream.Collectors;

import ch.twaenny.bookshelf.model.AppUser;

public class UserDto {

	public Long id;
	public final String userName;
	public List<String> roles;
	public List<BookDto> book;

	public UserDto(AppUser user) {
		this.id = user.getId();
		this.userName = user.getUsername();
		this.roles = user.getRoles();
		this.book = user.getBook()
				.stream()
				.map(BookDto::new)
				.collect(Collectors.toList());
	}

}
