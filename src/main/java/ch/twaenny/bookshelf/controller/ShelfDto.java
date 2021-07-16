package ch.twaenny.bookshelf.controller;

import ch.twaenny.bookshelf.model.Shelf;

public class ShelfDto {
	public Long id;
	public final String name;
	public String ort;
	
	public ShelfDto(Shelf shelf) {
		this.id = shelf.getId();
		this.name = shelf.getName();
		this.ort = shelf.getOrt();
	}
}
