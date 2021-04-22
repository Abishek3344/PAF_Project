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
}
