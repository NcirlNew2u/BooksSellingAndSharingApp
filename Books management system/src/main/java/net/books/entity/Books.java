package net.books.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Books {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "edition")
	private String edition;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price", nullable = false)
	private String price;
	
	@Column(name = "PlaceAvaiable", nullable = false)
	private String PlaceAvaiable;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Lob
	@Column(name = "data")
	private String data;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
			fetch = FetchType.LAZY)
	private User theUser;
	public Books() {
		
	}
	
	
	public Books(String title, String author, String edition, String description, String price, String placeAvaiable,
			String email, String data) {
		super();
		this.title = title;
		this.author = author;
		this.edition = edition;
		this.description = description;
		this.price = price;
		PlaceAvaiable = placeAvaiable;
		this.email = email;
		this.data = data;
		
	}

	//getter and setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getPlaceAvaiable() {
		return PlaceAvaiable;
	}

	public void setPlaceAvaiable(String placeAvaiable) {
		PlaceAvaiable = placeAvaiable;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}