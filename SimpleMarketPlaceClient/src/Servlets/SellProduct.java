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
 * Servlet implementation class SellProduct
 */
@WebServlet("/SellProduct")
public class SellProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SimpleMarketPlaceProxy proxy=new SimpleMarketPlaceProxy();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductCatalogs[] productCatalogs;
		
		productCatalogs=proxy.getCatalogs();
		request.setAttribute("catalogList", productCatalogs);
		request.getRequestDispatcher("SellProduct.jsp").forward(request, response);
		System.out.println("In Servlets GET of SellProduct !!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String opresult,productName,catalogName,productDescription,sellerInfo,userID;
		int productCost,productQuantity;
		HttpSession session=request.getSession(false);
		
		try
		{			
			System.out.println("SellingProduct in MarketPlace");
			proxy.setEndpoint("http://localhost:8080/SimpleMarketPlace/services/SimpleMarketPlace");
			productName = request.getParameter("inputProductName");
			catalogName = request.getParameter("category_list_product");
			System.out.println("Category name:"+catalogName);
			userID=(String)session.getAttribute("userName");
			System.out.println("UserID inserting in DB:"+userID);
			productDescription = request.getParameter("inputProductDescription");
			sellerInfo=request.getParameter("inputSellerInfo");
			productCost = Integer.parseInt(request.getParameter("inputProductCost"));
			productQuantity = Integer.parseInt(request.getParameter("inputProductQuantity"));
			opresult=proxy.addProduct(productName,catalogName,userID,productDescription,sellerInfo,productCost,productQuantity);
			
			if(opresult.substring(0,4).equals("true"))
			{
				request.setAttribute("isProductExists","Product added in sold List");
				request.getRequestDispatcher("SellProduct.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("isProductExists","Same Product already exists");
				System.out.println("Catalog already exists !! "+request.getAttribute("isValidUser"));
				request.getRequestDispatcher("SellProduct.jsp").forward(request, response);
			}
		}
		catch (Exception e)
        {
			 e.printStackTrace();
        }
	}
}
