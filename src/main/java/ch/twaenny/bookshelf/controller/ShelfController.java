package ch.twaenny.bookshelf.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.twaenny.bookshelf.service.ShelfService;

@RestController()
@RequestMapping("rest/v1/shelf")
public class ShelfController {
	@Autowired
	private ShelfService shelfService;
	
	
	// returns all shelves
	@GetMapping("")
	List<ShelfDto> getAllShelf() {
		return shelfService.getAllShelf()
			.stream()
			.map(shelf -> new ShelfDto(shelf))
			.collect(Collectors.toList());
	}
	
	// returns new Shelf
	@PostMapping("")
	ShelfDto insertShelf(@RequestBody  ShelfInputDto shelfInput) {
		
		return new ShelfDto(
				shelfService.addShelf(
						shelfInput.name, 
						shelfInput.ort)
			);
	}
}
