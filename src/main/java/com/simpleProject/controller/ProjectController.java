package com.simpleProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simpleProject.entity.ProjectEntity;
import com.simpleProject.service.ProjectService;

@Controller
public class ProjectController {

	@Autowired
	private ProjectService projServ;
	
	@RequestMapping("/home")
	@ResponseBody
	public ResponseEntity<List<ProjectEntity>> homePageResponse() {
		List<ProjectEntity> projectEntityList = projServ.findAllProjects();
		return new ResponseEntity<List<ProjectEntity>>(projectEntityList, HttpStatus.OK);
	}
	
	@RequestMapping("/home/{firstname}")
	@ResponseBody
	//public ResponseEntity<List<ProjectEntity>> findProjByFirstName(@PathVariable(value = "firstname") String firstname) {
	public List<ProjectEntity> findProjByFirstName(@PathVariable(value = "firstname") String firstname) {
		// System.out.println(firstname);
		List<ProjectEntity> projectEntityList = projServ.findProjectsByFirstName(firstname);
		return projectEntityList;
		//return new ResponseEntity<List<ProjectEntity>>(projectEntityList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/simple-project/projects",method = RequestMethod.PUT)
	public ResponseEntity<ProjectEntity> createProject(@RequestBody ProjectEntity pe){
		ProjectEntity savedProjectEntity = projServ.createProject(pe);
		return new ResponseEntity<ProjectEntity>(savedProjectEntity,HttpStatus.OK);
	}
}
