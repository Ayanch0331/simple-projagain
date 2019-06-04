package com.simpleProject.repository;

public interface IQuery {
	
	public String FINDALL = "Select pe from ProjectEntity pe";	
	public String FINDBYFIRSTNAME = "Select pe from ProjectEntity pe Where pe.firstName=?1";
	
	public String FINDPOSTBYAUTHORID = "Select poen from PostEntity poen Where poen.authorEntity.id=?1";
	public String FINDALLPOSTS = "Select poen from PostEntity poen";
	
	public String FindAllAuthors = "Select ae from AuthorEntity ae";
}
