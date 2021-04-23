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
	@Path("/getAll") //url path 
	@Produces(MediaType.TEXT_HTML)
	public String readProjects()
	 {
		return productObj.getProducts();
	 } 
	
	@GET
	@Path("/getById") //url path 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String getProject(@QueryParam("ID") String ID) // get id from query param
	{	
			String output = productObj.getProductByID(ID);
			return output;
	}
	
	@POST
	@Path("/add") //url path 
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
	@Path("/update") //url path 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateProject(String itemData) // get data from json object
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
	
	@DELETE
	@Path("/delete") //url path 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteProject(@QueryParam("ID") String ID) //get id from query param
	{	
			String output = productObj.deleteProduct(ID);
			return output;
	}
}
