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
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertItem(@FormParam("projectName") String projectName, @FormParam("projectDetails") String projectDetails,
			@FormParam("projectFund") String projectFund) {
		String output = projectObj.insertItem(projectName, projectDetails, projectFund);
		return output;
	}

}
