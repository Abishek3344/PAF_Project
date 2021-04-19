package com;

import model.Project;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Projects") 
public class ProjectService {
	
	Project projectObj = new Project();
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readProjects()
	 {
		return projectObj.readProjects();
	 } 

}
