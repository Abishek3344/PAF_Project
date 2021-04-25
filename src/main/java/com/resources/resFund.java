package com.resources;

public class resFund {
cntFund app = new cntFund();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("fund")
	public List<fund> getfunds()
	{
		System.out.println("getfund called...");
		return app.getFund();
	}
	
	
	
	@GET
	@Path("fund/{funderID}")
	@Produces(MediaType.APPLICATION_JSON)
	public fund getfund(@PathParam("funderID") int funderID)
	{
		return app.getfund(funderID);
	
	}
	
	@POST
	@Path("/fund")
	@Consumes(MediaType.APPLICATION_JSON)
	public fund createfund(fund p1)
	{
		System.out.println(p1);
		app.create(p1);
		
		return p1;
	}
	
	
	@PUT
	@Path("/funds")
	@Consumes(MediaType.APPLICATION_JSON)
	public fund updatefund(fund p1)
	{
		System.out.println(p1);
		if(app.getfund(p1.getfund_id()).getfund_id()==0) {
			app.create(p1);
			
		}
		else
		{
			app.update(p1);
			
		}
		
		return p1;
	}
	
	
	@DELETE
	@Path("fund/{FID}")
	public fund deletePatient(@PathParam("FID") int FID)
	{
		fund p = app.getfund(FID);
		
		if(p.getfund_id()!=0)
			app.delete(FID);
		return null;
	}
}
