package ch.twaenny.bookshelf.model;

public interface Book {
	
	public Long getID();
	public String getName();
	public Integer getIsbn();
	public AppUser getLoanee();
}
