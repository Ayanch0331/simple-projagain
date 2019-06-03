package com.simpleProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
}
