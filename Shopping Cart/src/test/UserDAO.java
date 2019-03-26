package test;

import java.sql.*;
public class UserDAO {
	public boolean validate (String uname, String pword) {
		try{
			Connection con=DBConnection.getConnection();
			Statement st=con.createStatement();
			// System.out.println(uname);
			// System.out.println(pword);
			  
			ResultSet rs=st.executeQuery("select * from UserReg15 where uname=\'"+uname+"\' and pword=\'"+pword+"\'");
			
				// System.out.println(rs.next());
				  
			
			return rs.next();
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}


}
