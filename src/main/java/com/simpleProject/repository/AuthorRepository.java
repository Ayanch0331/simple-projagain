package com.simpleProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.simpleProject.entity.AuthorEntity;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
	
	@Query(IQuery.FindAllAuthors)
	List<AuthorEntity> findAllAuthors();
	
}
