package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
@SuppressWarnings("serial")
public class LogoutServlet extends HttpServlet {
	 
	  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	  HttpSession hs=req.getSession(false);
	  if(hs!=null){
		 
	  hs.invalidate();
	  RequestDispatcher rd=req.getRequestDispatcher("index.html");
	  rd.forward(req,res);
	  return; 
	   }
	  }
}