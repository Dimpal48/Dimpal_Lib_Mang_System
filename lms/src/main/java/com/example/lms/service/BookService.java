package com.example.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lms.entity.Author;
import com.example.lms.entity.Book;
import com.example.lms.repo.BookRepo;

@Service
public class BookService {

	@Autowired
	private BookRepo bookRepo;
	
	public List<Book>getAllBooks(){
		return bookRepo.findAll();
	}
	public Book getBookById(int id) {
		return bookRepo.findById(id).orElse(null);
	}
	public Book saveorUpdateBook(Book book) {
		return bookRepo.save(book);
	}
	public void deleteBookById(int id) {
		bookRepo.findById(id).orElse(null);
		bookRepo.deleteById(id);
	}
}
