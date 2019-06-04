package com.simpleProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simpleProject.entity.AuthorEntity;
import com.simpleProject.service.AuthorService;

@RestController
public class AuthorController {

	@Autowired
	private AuthorService authServ;
	
	@RequestMapping(value = "/simple-project/authors", method = RequestMethod.GET)
	public ResponseEntity<List<AuthorEntity>> getAllAuthors() {
		List<AuthorEntity> ae = authServ.findAllAuthors();
		return new ResponseEntity<List<AuthorEntity>>(ae, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/simple-project/authors", method = RequestMethod.POST)
	public AuthorEntity createAuthor(@RequestBody AuthorEntity ae) {
		AuthorEntity savedAuthorEntity = authServ.createAuthor(ae);
		return savedAuthorEntity;
	}
	
}
