package ch.twaenny.bookshelf.model;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "Shelf")
public class ShelfImpl implements Shelf{
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String ort;
	
	@OneToMany(mappedBy = "shelf", fetch = FetchType.EAGER)
	private List<BookImpl> books;
	
	protected ShelfImpl() {}
	
	public ShelfImpl(Long id, String name, String ort) {
		this.id = id;
		this.name = name;
		this.ort = ort;
	}
	
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	@Override
	public String getOrt() {
		// TODO Auto-generated method stub
		return ort;
	}
	@Override
	public List<Book> getBook() {
		// TODO Auto-generated method stub
		return books.stream().collect(Collectors.toList());
	}
	
	
}
