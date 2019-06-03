package com.simpleProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleProject.entity.AuthorEntity;
import com.simpleProject.repository.AuthorRepository;

@Service
public class AuthorService implements IAuthorService {

	@Autowired
	private AuthorRepository authorRepo;
	
	@Override
	public List<AuthorEntity> findAllAuthors() {
		List<AuthorEntity> aeList = authorRepo.findAllAuthors();
		return aeList;
	}

}
