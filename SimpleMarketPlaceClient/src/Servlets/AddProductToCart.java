package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lab2.SimpleMarketPlace.WebServices.SimpleMarketPlaceProxy;

/**
 * Servlet implementation class AddProductToCart
 */
@WebServlet("/AddProductToCart")
public class AddProductToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SimpleMarketPlaceProxy proxy=new SimpleMarketPlaceProxy();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In Servlet GET of AddProductToCart");
		
		response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
	    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
	    response.getWriter().write("AjaxCall");  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String email,sessionID,opresult,productName;
		int quantity,price;
		HttpSession session=request.getSession(false);
		
		System.out.println("In Servlet POST of AddProductToCart");
		System.out.println("Prduct Name:"+request.getParameter("product_name"));
		System.out.println("Prduct Count:"+request.getParameter("quantity"));
		System.out.println("Prduct Price:"+request.getParameter("price").substring(12));
		
		try
		{			
			email=(String)session.getAttribute("userName");
			sessionID=session.getId();
			productName=request.getParameter("product_name");
			quantity=Integer.parseInt(request.getParameter("quantity"));
			price=Integer.parseInt(request.getParameter("price").substring(12));
			opresult=proxy.addProductToCart(email,sessionID,productName,quantity,price);
			
			if(opresult.substring(0,4).equals("true"))
			{
				System.out.println("Prodyct added to cart successfully !!");
				request.getRequestDispatcher("ShowCatalogs.jsp").forward(request, response);
			}
			else
			{
				System.out.println("Error while adding items to cart !!");
				request.getRequestDispatcher("ShowCatalogs.jsp").forward(request, response);
			}
		}
		catch (Exception e)
        {
			 e.printStackTrace();
        }
		
	}

}
