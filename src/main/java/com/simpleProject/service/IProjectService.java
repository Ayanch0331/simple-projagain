package com.simpleProject.service;

import java.util.List;

import com.simpleProject.entity.ProjectEntity;

public interface IProjectService {
	
	List<ProjectEntity> findAllProjects();	

	List<ProjectEntity> findProjectsByFirstName(String firstname);
	
	ProjectEntity createProject(ProjectEntity pe);
	
}
