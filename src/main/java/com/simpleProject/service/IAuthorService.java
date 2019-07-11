package com.simpleProject.service;

import java.util.List;

import com.simpleProject.entity.AuthorEntity;

public interface IAuthorService {

	List<AuthorEntity> findAllAuthors();
	//for new branch
	AuthorEntity createAuthor(AuthorEntity ae);
	
}
