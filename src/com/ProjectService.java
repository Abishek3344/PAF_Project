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
	public String insertProject(@FormParam("projectName") String projectName, 
							@FormParam("projectDetails") String projectDetails,
							@FormParam("projectFund") String projectFund) 
	{
		String output = projectObj.insertProject(projectName, projectDetails, projectFund);
		return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateProject(String itemData)
	{
			//Convert the input string to a JSON object
			JsonObject projectObject = new JsonParser().parse(itemData).getAsJsonObject();
	
			//Read the values from the JSON object
			String projectID = projectObject.get("projectID").getAsString();
			String projectName = projectObject.get("projectName").getAsString();
			String projectDetails = projectObject.get("projectDetails").getAsString();
			String projectFund = projectObject.get("projectFund").getAsString();
	
			String output = projectObj.updateProject(projectID, projectName, projectDetails, projectFund);
	
			return output;
	}

}
