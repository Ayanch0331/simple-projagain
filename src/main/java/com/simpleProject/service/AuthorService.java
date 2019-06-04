package com.simpleProject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleProject.entity.AuthorEntity;
import com.simpleProject.entity.PostEntity;
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

	@Override
	public AuthorEntity createAuthor(AuthorEntity ae) {
		AuthorEntity savedAe = authorRepo.save(ae);
		savedAe.addPost(new ArrayList<PostEntity>(savedAe.getPostEntityList()));
		return savedAe;
	}

}
