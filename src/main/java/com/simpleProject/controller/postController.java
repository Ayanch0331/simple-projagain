package com.simpleProject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.simpleProject.entity.AuthorEntity;
// import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.simpleProject.entity.PostEntity;
import com.simpleProject.service.PostService;
import org.springframework.http.MediaType;

@RestController
public class postController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping("/posts")
	@ResponseBody
	public List<PostEntity> getAllPosts() {
		List<PostEntity> pe = postService.findAllPosts();
		return pe;
	}

	@RequestMapping(value = "/posts/{id}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<PostEntity>> getAllPostsById(@PathVariable("id") String id) {
		System.out.println(id);
		List<PostEntity> pe = postService.findAllPostsByAuthorID(id);
		return new ResponseEntity<List<PostEntity>>(pe,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/simple-project/{authorID}/Post", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AuthorEntity> createPost(@PathVariable("authorID") Long authorId, @RequestBody ArrayList<PostEntity> pe) {
		AuthorEntity savedPostEntity = postService.createPost(authorId,pe);
		return new ResponseEntity<AuthorEntity>(savedPostEntity,HttpStatus.OK);
	}
}
