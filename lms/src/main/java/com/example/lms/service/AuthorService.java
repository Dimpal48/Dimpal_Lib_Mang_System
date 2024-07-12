package com.example.lms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lms.entity.Author;
import com.example.lms.repo.AuthorRepo;

@Service
public class AuthorService {
     
	private AuthorRepo authorRepo;
	
	public List<Author>getAllAuthors(){
		return authorRepo.findAll();
	}
	public Author getAuthorById(int id) {
		return authorRepo.findById(id).orElse(null);
	}
	public Author saveorUpdateAuthor(Author author) {
		return authorRepo.save(author);
	}
	public void deleteAuthorById(int id) {
		authorRepo.findById(id).orElse(null);
		authorRepo.deleteById(id);
	}
	
	
}
