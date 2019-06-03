package com.simpleProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.simpleProject.entity.ProjectEntity;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {

	@Query(IQuery.FINDALL)
	List<ProjectEntity> findAllProjects();
	
	@Query(IQuery.FINDBYFIRSTNAME)
	List<ProjectEntity> findProjectsByFirstName(String firstname);
	
}
