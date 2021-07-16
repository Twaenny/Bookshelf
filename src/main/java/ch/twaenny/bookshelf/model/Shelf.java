package ch.twaenny.bookshelf.model;

import java.util.List;

public interface Shelf {
	public Long getId();
	public String getName();
	public String getOrt();
	public List<Book> getBook();
}
