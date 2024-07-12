package com.example.lms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lms.entity.Author;
import com.example.lms.entity.Book;
import com.example.lms.service.AuthorService;
import com.example.lms.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book>books=bookService.getAllBooks();
		return ResponseEntity.ok(books);		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBook(@PathVariable int id) {
		Book book=bookService.getBookById(id);
		if(book==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(book);		
	}
	
	
	@PostMapping("/{id}")
	public ResponseEntity<Book> saveBook(@RequestBody Book book) {
		List<Author> authors=new ArrayList<Author>();
		for(Author author: book.getAuthors()) {
			Author foundauthor=authorService.getAuthorById(author.getId());
			if(foundauthor==null) {
				return ResponseEntity.notFound().build();
			}
			authors.add(foundauthor);
		}
		book.setAuthors(authors);
		Book createdBook=bookService.saveorUpdateBook(book);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book ) {
		Book existingBook=bookService.getBookById(id);
		if(existingBook==null) {
			return ResponseEntity.notFound().build();
		}
		
		List<Author> authors=new ArrayList<Author>();
		for(Author author: book.getAuthors()) {
			Author foundauthor=authorService.getAuthorById(author.getId());
			if(foundauthor==null) {
				return ResponseEntity.notFound().build();
			}
			authors.add(foundauthor);
		}
		book.setAuthors(authors);
		
		
		book.setId(id);
		bookService.saveorUpdateBook(book);
		return ResponseEntity.ok(book);		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable int id) {
		Book book=bookService.getBookById(id);
		if(book==null) {
			return ResponseEntity.notFound().build();
		}
		bookService.deleteBookById(id);
		return ResponseEntity.noContent().build();		
	}
	

}
