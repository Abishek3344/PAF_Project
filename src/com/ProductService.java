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
}
