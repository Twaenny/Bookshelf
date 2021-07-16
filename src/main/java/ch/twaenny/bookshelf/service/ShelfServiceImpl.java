package ch.twaenny.bookshelf.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.twaenny.bookshelf.exception.BookAlreadyExistsException;
import ch.twaenny.bookshelf.exception.InvalidArgumentException;
import ch.twaenny.bookshelf.exception.ShelfNotFoundException;
import ch.twaenny.bookshelf.model.Shelf;
import ch.twaenny.bookshelf.repository.ShelfRepository;

@Service
public class ShelfServiceImpl implements ShelfService {
	@Autowired
	ShelfRepository repo;
	

	@Override
	public List<Shelf> getAllShelf() {
		List<Shelf> shelves = new ArrayList<>();
		
		for (var shelf : repo.findAll()) {
			shelves.add(shelf);
		}
		return shelves;
	}


	@Override
	public Shelf addShelf(String name, String ort) {
		if(name == null || ort == null) {
			throw new InvalidArgumentException();
		} 
		if(repo.findByName(name).isPresent()) {
			throw new BookAlreadyExistsException();
		}
		return repo.insertShelf(name, ort);
	}


	@Override
	public Shelf findByName(String name) {
		if (name == null) {
			throw new InvalidArgumentException();
		}
		return repo.findByName(name)
				.orElseThrow(ShelfNotFoundException:: new);
	}


	@Override
	public Shelf getShelfById(long shelfId) {
		return repo.findById(shelfId)
				.orElseThrow(ShelfNotFoundException:: new);
	}

}
