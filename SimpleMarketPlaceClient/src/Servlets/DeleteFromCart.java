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
 * Servlet implementation class DeleteFromCart
 */
@WebServlet("/DeleteFromCart")
public class DeleteFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SimpleMarketPlaceProxy proxy=new SimpleMarketPlaceProxy();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFromCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String email,sessionID,opresult,productName;
		int quantity;
		HttpSession session=request.getSession(false);
		
		System.out.println("In Servlet POST of DeleteFromCart");
		System.out.println("Prduct Name:"+request.getParameter("product_name"));
		System.out.println("Prduct Count:"+request.getParameter("product_count").substring(17));
		
		try
		{			
			email=(String)session.getAttribute("userName");
			sessionID=session.getId();
			productName=request.getParameter("product_name");
			quantity=Integer.parseInt(request.getParameter("product_count").substring(17));
			opresult=proxy.deleteProductFromCart(email,productName,quantity);
			
			if(opresult.substring(0,4).equals("true"))
			{
				System.out.println("Product deleted from cart successfully !!");
				request.getRequestDispatcher("MyCart.jsp").forward(request, response);
			}
			else
			{
				System.out.println("Error while adding deleting from cart !!");
				request.getRequestDispatcher("MyCart.jsp").forward(request, response);
			}
		}
		catch (Exception e)
        {
			 e.printStackTrace();
        }
	}
}
