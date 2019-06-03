package com.simpleProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleProject.entity.ProjectEntity;
import com.simpleProject.repository.ProjectRepository;

@Service
public class ProjectService implements IProjectService {
	
	@Autowired
	private ProjectRepository projRepo;
	
	@Override
	public List<ProjectEntity> findAllProjects() {
		List<ProjectEntity> pe = projRepo.findAll();
		return pe;
	}
	
	@Override
	public List<ProjectEntity> findProjectsByFirstName(String firstname) {
		List<ProjectEntity> pe = projRepo.findProjectsByFirstName(firstname);
		return pe;
	}

	@Override
	public ProjectEntity createProject(ProjectEntity pe) {
		ProjectEntity savedPe = projRepo.save(pe);
		return savedPe;
	}
	
}
