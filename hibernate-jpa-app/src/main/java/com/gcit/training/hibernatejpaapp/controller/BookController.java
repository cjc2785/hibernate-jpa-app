package com.gcit.training.hibernatejpaapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.gcit.training.hibernatejpaapp.dao.*;
import com.gcit.training.hibernatejpaapp.entity.*;

@RestController
@RequestMapping("/lms")
public class BookController {

	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private AuthorDao authorDao;
	
	@Autowired
	private PublisherDao publisherDao;
	
	@GetMapping("/books")
	public List<Book> getAllBook() {
	    return bookDao.findAll();
	}
	
	@GetMapping("/books/{bookId}")
	public Book getAllBook(@PathVariable("bookId") int bookId) throws ResourceException {
	    return bookDao.findById(bookId).orElseThrow(ResourceException::new);
	}
	
	
	@PostMapping("/books")
	public Book update(@Valid @RequestBody Book book) throws ResourceException {
		if(bookDao.existsById(book.getBookId())) {
			throw new ResourceException();
		}
		validate(book);
		return bookDao.save(book);
	}
	
	@PutMapping("/books")
	public Book create(@Valid @RequestBody Book book) throws ResourceException {
		
		validate(book);
	    return bookDao.save(book);
	}
	
	@DeleteMapping("/books/{bookId}")
	public void delete(@PathVariable("bookId") int bookId) throws ResourceException {
		bookDao.findById(bookId).orElseThrow(ResourceException::new);
		bookDao.deleteById(bookId);
	}
	
	
	
	private void validate(Book book) throws ResourceException {

		Author author = book.getAuthor();
		Publisher publisher = book.getPublisher();
		
	
		int authorId = author.getAuthorId();
		int publisherId = publisher.getPublisherId();
		
		authorDao.findById(authorId).orElseThrow(ResourceException::new);
		publisherDao.findById(publisherId).orElseThrow(ResourceException::new);
	}
}
