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
 * Servlet implementation class CheckOut
 */
@WebServlet("/CheckOut")
public class CheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SimpleMarketPlaceProxy proxy=new SimpleMarketPlaceProxy();   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In Servlet CheckOut GET call");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In Servlet CheckOut POST call");
		String opresult,email,sessionID;
		HttpSession session=request.getSession(false);
		
		try
		{			
			email=(String)session.getAttribute("userName");
			sessionID=session.getId();
			opresult=proxy.checkOut(email, sessionID);
			
			if(opresult.substring(0,4).equals("true"))
			{
				System.out.println("Check out done successfully !!");
				request.getRequestDispatcher("CheckOut.jsp").forward(request, response);
			}
			else
			{
				System.out.println("Error in check out !!");
				request.getRequestDispatcher("MyCart.jsp").forward(request, response);
			}
		}
		catch (Exception e)
        {
			 e.printStackTrace();
        }
	}

}
