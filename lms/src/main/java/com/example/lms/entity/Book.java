package com.example.lms.entity;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name="books")
public class Book {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@OneToMany
	@JoinTable(name="books_authors",
	          joinColumns= { @JoinColumn(name="book_id")},
	          inverseJoinColumns= {@JoinColumn(name="author_id")})	
	private List<Author> authors;
	
	public Book() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Author> getAuthors() {
		return authors;
	} 
	
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
	
	
}
