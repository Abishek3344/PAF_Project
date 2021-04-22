package com;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;

import model.Product;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Products") 

public class ProductService {
	Product productObj = new Product();
	
	@GET
	@Path("/getAll")
	@Produces(MediaType.TEXT_HTML)
	public String readProjects()
	 {
		return productObj.getProducts();
	 } 
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertProject(@FormParam("Name") String name, 
							@FormParam("Type") String type,
							@FormParam("Description") String des,
							@FormParam("Amount") String amount) 
	{
		String output = productObj.addProduct(name, type, des,amount);
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
			String id = projectObject.get("ID").getAsString();
			String name = projectObject.get("Name").getAsString();
			String type = projectObject.get("Type").getAsString();
			String des = projectObject.get("Description").getAsString();
			String amount = projectObject.get("Amount").getAsString();
	
			String output = productObj.updateProduct(id, name,type, des, amount);
	
			return output;
	}
}
