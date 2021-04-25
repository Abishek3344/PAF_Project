package com.controller;

public class cntFund {
Connection con = null;
	
	public controllerfund()
	{		 
		con = dbconnector.connector();
	} 

public List<fund>getfunds(){
   	 
   	 List<Fund> funds = new ArrayList<>();
   	 String sql = "select * from fund";
   	 try 
   	   {
			  Statement st = con.createStatement();
			  ResultSet rs = st.executeQuery(sql);
			  while(rs.next())
			  {
				  fund p = new fund();
				  p.setfund_id(rs.getInt(1));
				  p.setUser_id(rs.getInt(2));
				  p.setMethod(rs.getString(3));
				  p.setStatus(rs.getString(4));
				  p.setAmount(rs.getDouble(5));
				  p.setDate(rs.getDate(6));
				  p.setDescription(rs.getString(7));
				  				   
				  
				  funds.add(p);
			  }
			
		    } 
   	 catch (Exception e) 
   	  {
			
		   System.out.println(e);
		  }
   	  
   	 return funds;
    }
        
    
    public fund getfund(int fund_id)
    
    {
   	 String sql = "select * from fund where fund_id="+fund_id;
   	  fund p = new fund();
   	 try 
   	   {
			  Statement st = con.createStatement();
			  ResultSet rs = st.executeQuery(sql);
			  if(rs.next())
			  {
				
				  p.setfund_id(rs.getInt(1));
				  p.setUser_id(rs.getInt(2));
				  p.setMethod(rs.getString(3));
				  p.setStatus(rs.getString(4));
				  p.setAmount(rs.getDouble(5));
				  p.setDate(rs.getDate(6));
				  p.setDescription(rs.getString(7));
				  	
			  }
			
		    } 
   	 catch (Exception e) 
   	  {
			
		   System.out.println(e);
		  } 
   	 return p;
    }

	public void create(fund p1) 
	{
		String sql = "insert into fund values(?,?,?,?,?,?,?)";
  	 try 
	   {
		  PreparedStatement st = con.prepareStatement(sql);
		  st.setInt(1, p1.getfund_id());
		  st.setInt(2, p1.getUser_id());
		  st.setString(3, p1.getMethod());
		  st.setString(4, p1.getStatus());
		  st.setDouble(5, p1.getAmount());
		  st.setDate(6, p1.getDate());
		  st.setString(7, p1.getDescription());
         st.executeUpdate();
	
		
	    } 
	 catch (Exception e) 
	  {
		
	   System.out.println(e);
	  } 
		
	}
	
	
	public void update(fund p1) 
	{
		String sql = "update fund set method=?,status=?,amount=?,date=?,description=?,user_id=? where fund_id=?";
  	 try 
	   {
		  PreparedStatement st = con.prepareStatement(sql);

		  st.setString(1, p1.getMethod());
		  st.setString(2, p1.getStatus());
		  st.setDouble(3, p1.getAmount());
		  st.setDate(4, p1.getDate());
		  st.setString(5, p1.getDescription());
		  st.setInt(6, p1.getUser_id());
		  st.setInt(7, p1.getfund_id());
         st.executeUpdate();
	
		
	    } 
	 catch (Exception e) 
	  {
		
	   System.out.println(e);
	  } 
		
	}



	public void delete(int fund_id) {

		String sql = "delete from fund where fund_id=?";
  	 try 
	   {
		  PreparedStatement st = con.prepareStatement(sql);
		  st.setInt(1, fund_id);
         st.executeUpdate();
	
		
	    } 
	 catch (Exception e) 
	  {
		
	   System.out.println(e);
	  } 

	}
}
