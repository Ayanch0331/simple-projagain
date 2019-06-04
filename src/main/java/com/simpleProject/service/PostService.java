package com.simpleProject.service;

import java.util.ArrayList;
// import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.simpleProject.entity.AuthorEntity;
import com.simpleProject.entity.PostEntity;
import com.simpleProject.repository.AuthorRepository;
import com.simpleProject.repository.PostRepository;

@Service
public class PostService implements IPostService {

	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private AuthorRepository authRepo;
	
	@Override
	public List<PostEntity> findAllPostsByAuthorID(String id) {
		List<PostEntity> postEntityList = postRepo.findAllPostsByAuthorID(new Long(id));
		return postEntityList;
	}

	@Override
	public List<PostEntity> findAllPosts() {
		List<PostEntity> peList = postRepo.findAllPosts();
		return peList;
	}

	@Override
	public AuthorEntity createPost(Long authorId, ArrayList<PostEntity> pe) {		
		Optional<AuthorEntity> authorById = authRepo.findById(authorId);
		if (!authorById.isPresent()) {
            throw new ResourceNotFoundException("Author with id " + authorId + " does not exist");
        }
		
		AuthorEntity ae = authorById.get();
		ae.addPost(pe);
		AuthorEntity savedAuthEntity = authRepo.save(ae);
		
		return savedAuthEntity;
	}

}
