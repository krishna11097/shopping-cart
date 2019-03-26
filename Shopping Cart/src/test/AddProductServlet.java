package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
@SuppressWarnings("serial")
public class AddProductServlet extends HttpServlet {
	  public ProductsDAO productsdao;
	  @Override
	  public void init() throws ServletException {
		   productsdao = new ProductsDAO();
	  }
	  @Override
	  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	  HttpSession hs=req.getSession(false);
	  if(hs==null){
	  RequestDispatcher rd=req.getRequestDispatcher("index.html");
	  rd.forward(req,res);
	  return;
	   }
	  String uname=(String)hs.getAttribute("uname");

	  PrintWriter pw=res.getWriter();
	  res.setContentType("text/html");
	  @SuppressWarnings("unchecked")
	ArrayList<Product> products=(ArrayList<Product>)hs.getAttribute("products");
	  if(products==null){
		  products=new ArrayList<Product>();
		  hs.setAttribute("products", products); 
	  }
	 
	  String[] pcodes=req.getParameterValues("products");
			  for(int i=0;i<pcodes.length;i++){
		   if(req.getParameter(pcodes[i]).equals(""))
			   continue;
		   Product p=new Product();
		   p.code=pcodes[i];
		   int j=products.indexOf(p);
		   if(j!=-1){
			   p=(Product)products.get(j);
			   p.qty+=Double.parseDouble(req.getParameter(pcodes[i]));
		   
		   }
		    
		   else 
		   {
			   p.name=req.getParameter(pcodes[i]+"Name");
			   p.qty=Double.parseDouble(req.getParameter(pcodes[i]));
			   products.add(p);
		   }  
	   
	  }
	  
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
	   pw.println("<font size='6'>Welcome:"+uname+"</font><br>");
	   pw.println("Product added successfully to cart");
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