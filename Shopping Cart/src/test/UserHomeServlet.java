package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class UserHomeServlet extends HttpServlet {
   public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
	   HttpSession hs=req.getSession(false);
	   if(hs==null){
		   RequestDispatcher rd=req.getRequestDispatcher("Login.html");
		   rd.forward(req, res);
		   return;
	   }
	   else{
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
		   pw.println("<font size='6'>Welcome:"+uname+"</font></td>");
		   pw.println("</tr>");
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
}
