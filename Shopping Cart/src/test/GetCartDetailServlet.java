package test;
import java.io.*;
import java.sql.*;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.*;
import javax.servlet.http.*;
public class GetCartDetailServlet extends HttpServlet {
 public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	 HttpSession hs=req.getSession(false);
	 if(hs==null){
		 RequestDispatcher rd=req.getRequestDispatcher("index.html");
		 rd.forward(req, res);
    return;
	  }
	 String uname=(String)hs.getAttribute("uname");
	 PrintWriter pw=res.getWriter();
	 res.setContentType("text/html");
	 pw.println("<html><head>");
	   pw.println("<title>Shopping Cart </title>");
	   pw.println("</head><body>");
	   pw.println("<table width='100%' height='90%' border='1'>");
	   pw.println("<tr align='center'");
	   pw.println("<td height='39' colspan='5'>");
	   pw.println("<strong><font size='5'> MyShopping site </font>");
	   pw.println("</strong>");
	   pw.println("</tr>");
	   pw.println("<tr>");
	   pw.println("<td width='18%' height='500' valign='top'");
	   pw.println("<p>&nbsp</p>");
	   pw.println("<blockquote><p>");
	   pw.println("<a href='"+res.encodeURL("getProducts")+"'>");
	   pw.println("View Products</a></p>");
	   pw.println("<a href='"+res.encodeURL("get Cart")+"'>");
	   pw.println("View Cart Details</a></p>");
	   pw.println("<a href='"+res.encodeURL("Logout")+"'>");
	   pw.println("Logout</a></p>");
	   pw.println("<blockqoute></td>");
	   pw.println("<td width='82%' align='left' valign='top'>");
	   pw.println("<p>&nbsp</p>");
	   pw.println("<blockquote><p>");
	   pw.println("<font size='6'>Welcome:"+uname+"</font>");
	   pw.println("<center> Your cart contain the following Products");
	   pw.println("<table width='100' border='1'>");
	   pw.println("<tr>");
	   pw.println("<th width='25%'>Product code</th>");
	   pw.println("<th width='33%'>Product name</th>");
	   pw.println("<th width='30%'>Product qty</th>");
	   pw.println("</tr>");
	   Collection products=(Collection)hs.getAttribute("products");
	   if(products==null){
		   pw.println("<tr><td colspan='3' align='center'>");
		   pw.println("You have not added any products into the Cart");
		   pw.println("</td></tr>");
		   
	   }
	   else{
		   Iterator i=products.iterator();
		   while(i.hasNext()){
			   Product p=(Product)i.next();
			   pw.println("<tr>");
			   pw.println("<td>"+p.getCode()+"</td>");
			   pw.println("<td>"+p.getName()+"</td>");
			   pw.println("<td>"+p.getQty()+"</td>");
			   pw.println("/tr");
		   }
	   }
	   pw.println("</table></center>");
	   pw.println("</td><tr>");
	   pw.println("<tr align='center'>");
	   pw.println("<td colspan='2'>");
	   pw.println("<em>&copy;Copyrights 2018-1019</em></td>");
	   pw.println("</tr>");
	   pw.println("</table>");
	   pw.println("</body></html>");
	   pw.flush();
	   pw.close();	   
	 
	   
	   
 }
}
