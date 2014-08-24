package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lab2.SimpleMarketPlace.Models.ProductCatalogs;
import com.lab2.SimpleMarketPlace.Models.Products;
import com.lab2.SimpleMarketPlace.Models.ShoppingCart;
import com.lab2.SimpleMarketPlace.WebServices.SimpleMarketPlaceProxy;

/**
 * Servlet implementation class MyCart
 */
@WebServlet("/MyCart")
public class MyCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SimpleMarketPlaceProxy proxy=new SimpleMarketPlaceProxy();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShoppingCart[] shoppingCart;
		HttpSession session=request.getSession(false);
		
		if(session == null)
		{
			request.getRequestDispatcher("InvalidSession.jsp").forward(request, response);
		}	
		else if(session.getAttribute("userName") == null)
		{
			request.getRequestDispatcher("InvalidSession.jsp").forward(request, response);
		} 
		else
		{
			System.out.println("In Servlets GET of MyCart !!");
			shoppingCart=proxy.getProductsFromCart((String)session.getAttribute("userName"), session.getId());
			System.out.println("Session UID:"+session.getId());
			request.setAttribute("shoppingCartList", shoppingCart);
			request.getRequestDispatcher("MyCart.jsp").forward(request, response);
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
