package ch.twaenny.bookshelf.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ch.twaenny.bookshelf.model.Shelf;
import ch.twaenny.bookshelf.model.ShelfImpl;

public interface ShelfRepository extends CrudRepository<ShelfImpl, Long>{
	
	default Shelf insertShelf(String name, String ort) {
		return save(new ShelfImpl(null, name, ort));
		
	}

	@Query
	Optional<Shelf> findByName(String name);
}
