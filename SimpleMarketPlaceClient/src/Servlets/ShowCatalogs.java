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
import com.lab2.SimpleMarketPlace.WebServices.SimpleMarketPlaceProxy;

/**
 * Servlet implementation class ShowCatalogs
 */
@WebServlet("/ShowCatalogs")
public class ShowCatalogs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SimpleMarketPlaceProxy proxy=new SimpleMarketPlaceProxy();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCatalogs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductCatalogs[] productCatalogs;
		Products[] products;
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
			productCatalogs=proxy.getCatalogs();
			products=proxy.getProducts();
			System.out.println("Session UID:"+session.getId());
			request.setAttribute("catalogList", productCatalogs);
			request.setAttribute("productList",products);
			request.getRequestDispatcher("ShowCatalogs.jsp").forward(request, response);
			System.out.println("In Servlets GET of ShowCatalogs !!");
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
