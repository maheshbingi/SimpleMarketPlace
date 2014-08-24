package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lab2.SimpleMarketPlace.Models.ProductCatalogs;
import com.lab2.SimpleMarketPlace.WebServices.SimpleMarketPlaceProxy;

/**
 * Servlet implementation class SignIn
 */
@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SimpleMarketPlaceProxy proxy=new SimpleMarketPlaceProxy();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In Servlets GET of SignIn !!");
		request.getRequestDispatcher("SignIn.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String opresult,email,pwd;
		HttpSession session;
		
		try
		{			
			System.out.println("Sign In !!");
			proxy.setEndpoint("http://localhost:8080/SimpleMarketPlace/services/SimpleMarketPlace");
			email = request.getParameter("inputUsername");
			pwd = request.getParameter("inputPassword");
			opresult=proxy.signIn(email, pwd);
			
			// Create a session object if it is already not created.
			session = request.getSession(true);
			
			if(opresult.substring(0,4).equals("true"))
			{
				session.setAttribute("userSession", session);
				session.setAttribute("userName", email);
				session.setMaxInactiveInterval(600);
				session.setAttribute("lastlogin", opresult.substring(5, 24));
				
				request.setAttribute("isValidUser","");
				Servlets.ShowCatalogs sc=new Servlets.ShowCatalogs();
				sc.doGet(request, response);
			}
			else
			{
				request.setAttribute("isValidUser","Invalid username or password");
				System.out.println("Invalid username or pwd !!"+request.getAttribute("isValidUser"));
				request.getRequestDispatcher("SignIn.jsp").forward(request, response);
			}
		}
		catch (Exception e)
        {
			 e.printStackTrace();
        }
	}
}
