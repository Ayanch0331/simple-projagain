package com.simpleProject.service;

import java.util.ArrayList;
import java.util.List;

import com.simpleProject.entity.AuthorEntity;
import com.simpleProject.entity.PostEntity;

public interface IPostService {

	List<PostEntity> findAllPostsByAuthorID(String authorID);
	List<PostEntity> findAllPosts();	
	AuthorEntity createPost(Long authorId, ArrayList<PostEntity> pe);
}
