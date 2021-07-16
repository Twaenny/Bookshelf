package ch.twaenny.bookshelf.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "Book")
public class BookImpl implements Book {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Integer isbn;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private AppUserImpl loanee;
	@ManyToOne(cascade = CascadeType.DETACH)
	private ShelfImpl shelf;
	protected BookImpl() {}
	
	public BookImpl(Long id, String name, Integer kennzeichen, AppUser mieter, Shelf shelf) {
		this.id = id;
		this.name = name;
		this.isbn = kennzeichen;
		this.loanee = (AppUserImpl) mieter;
		this.shelf = (ShelfImpl) shelf;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public Integer getIsbn() {
		// TODO Auto-generated method stub
		return isbn;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setKennzeichen(Integer kennzeichen) {
		this.isbn = kennzeichen;
	}

	@Override
	public Long getID() {
		return id;
	}

	@Override
	public AppUser getLoanee() {
		return loanee;
	}
	
}
