package com.simpleProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.simpleProject.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
	
	@Query(IQuery.FINDPOSTBYAUTHORID)
	List<PostEntity> findAllPostsByAuthorID(Long AuthorID);
	
	@Query(IQuery.FINDALLPOSTS)
	List<PostEntity> findAllPosts();
}
