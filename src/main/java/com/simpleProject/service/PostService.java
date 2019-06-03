package com.simpleProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@SuppressWarnings("unchecked")
	@Override
	public PostEntity createPost(PostEntity pe) {
//		PostEntity savedPE = postRepo.save(pe);
		AuthorEntity ae = authRepo.getOne(new Long(pe.getAuthorEntity().getId()));
		PostEntity postEntity = new PostEntity();
		postEntity.setAuthorEntity(ae);
		PostEntity savedPE = postRepo.save(postEntity);		
		return savedPE;
	}

}
