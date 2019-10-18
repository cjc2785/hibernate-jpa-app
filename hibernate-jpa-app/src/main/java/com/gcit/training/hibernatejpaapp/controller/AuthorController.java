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
public class AuthorController {

	@Autowired
	private AuthorDao authorDao;
	
	@GetMapping("/authors")
	public List<Author> getAllBook() {
	    return authorDao.findAll();
	}
	
	@GetMapping("/authors/{authorId}")
	public Author getAllBook(@PathVariable("authorId") int authorId) throws ResourceException {
	    return authorDao.findById(authorId).orElseThrow(ResourceException::new);
	}
	
	@PostMapping("/authors")
	public Author update(@Valid @RequestBody Author author) throws ResourceException {
		if(authorDao.existsById(author.getAuthorId())) {
			throw new ResourceException();
		}
		return authorDao.save(author);
	}
	
	
	@PutMapping("/authors")
	public Author create(@Valid @RequestBody Author author) {
	    return authorDao.save(author);
	}
	
	@DeleteMapping("/authors/{authorId}")
	public void delete(@PathVariable("authorId") int authorId) throws ResourceException {
		authorDao.findById(authorId).orElseThrow(ResourceException::new);
		authorDao.deleteById(authorId);
	}
}
