package com.simpleProject.service;

import java.util.List;

import com.simpleProject.entity.PostEntity;

public interface IPostService {

	List<PostEntity> findAllPostsByAuthorID(String authorID);
	List<PostEntity> findAllPosts();
	PostEntity createPost(PostEntity pe);
}
