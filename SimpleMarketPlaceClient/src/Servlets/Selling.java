package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lab2.SimpleMarketPlace.WebServices.SimpleMarketPlaceProxy;


/**
 * Servlet implementation class Selling
 */
@WebServlet("/Selling")
public class Selling extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SimpleMarketPlaceProxy proxy=new SimpleMarketPlaceProxy();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Selling() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In Servlets GET of Selling !!");
		request.getRequestDispatcher("Selling.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String opresult,catalogName;
		
		try
		{			
			System.out.println("Selling :: Add Catalog");
			proxy.setEndpoint("http://localhost:8080/SimpleMarketPlace/services/SimpleMarketPlace");
			catalogName = request.getParameter("inputCatalogName");
			opresult=proxy.addCatalog(catalogName);
			
			if(opresult.substring(0,4).equals("true"))
			{
				request.setAttribute("isCatalogExists","Catalog added successfully");
				request.getRequestDispatcher("Selling.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("isCatalogExists","Catalog already exists");
				System.out.println("Catalog already exists !! "+request.getAttribute("isValidUser"));
				request.getRequestDispatcher("Selling.jsp").forward(request, response);
			}
		}
		catch (Exception e)
        {
			 e.printStackTrace();
        }
	}
}
