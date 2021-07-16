package ch.twaenny.bookshelf.service;

import java.util.List;

import ch.twaenny.bookshelf.model.Shelf;

public interface ShelfService {
	
	List<Shelf> getAllShelf();
	
	Shelf addShelf(String name, String ort);
	
	Shelf findByName(String name);
	
	Shelf getShelfById(long shelfId);
	
	

}
