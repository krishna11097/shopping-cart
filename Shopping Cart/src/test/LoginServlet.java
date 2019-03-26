package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
  public UserDAO ud;
  @Override
  public void init()  {
	  ud= new UserDAO();
  }
  @Override
  public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	  PrintWriter pw=res.getWriter();
	  res.setContentType("text/html");
	  String uname=req.getParameter("uname");
	  String pword=req.getParameter("pword");
	   ud=new UserDAO();
	 // System.out.println(uname);
	//  System.out.println(pword);
	  
	  
          if(ud.validate(uname,pword)){
        	//  System.out.println("jfdka");
        	HttpSession hs=req.getSession();
        	hs.setAttribute("uname",uname);
        	  RequestDispatcher rd=req.getRequestDispatcher("home");
        	  rd.forward(req,res);
          }
          else {
        	 // System.out.println("hghjg");
        	 
   		   pw.println("<tr align='left'");
   		   pw.println("<td height='30' colspan='3'>");
   		   pw.println("</tr>");
        	  pw.println("invalid User or password");
        	  RequestDispatcher rd=req.getRequestDispatcher("index.html");
        	  rd.include(req,res);
        	  
          }
	  }
  
}

