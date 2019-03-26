package test;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class ProductsDAO {
	@SuppressWarnings({ })
	public Collection<Product> getProducts() { 
		Collection<Product> products = null;
    	 try{
    		 Connection con = DBConnection.getConnection();
    		 PreparedStatement ps=con.prepareStatement("select * from Product20");
    		  ResultSet rs=ps.executeQuery();
    		 System.out.println(rs.next());
    		    products=new ArrayList<Product>();
    		   while(rs.next()){
    			   Product p=new Product();
    			   p.code=rs.getString(1);
    			   p.name=rs.getString(2);
    			   p.qty=rs.getDouble(3);
    			   products.add(p);
    	   
    			   } 
    		 
    		   }
    	 catch(Exception e){
    			   e.printStackTrace();
    	 }
		
		return products;  
    	
     }
    
}
     
