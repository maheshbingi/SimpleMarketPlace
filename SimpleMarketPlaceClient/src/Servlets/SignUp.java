package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lab2.SimpleMarketPlace.WebServices.SimpleMarketPlaceProxy;


@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SimpleMarketPlaceProxy proxy=new SimpleMarketPlaceProxy();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In Servlets GET of SignUp !!");
		request.getRequestDispatcher("SignUp.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String opresult,email,pwd,fname,lname;	
		HttpSession session;
		
		System.out.println("Sign Up !!");
			
		proxy.setEndpoint("http://localhost:8080/SimpleMarketPlace/services/SimpleMarketPlace");
		fname = request.getParameter("inputFirstName");
		lname = request.getParameter("inputLastName");
		email = request.getParameter("inputEmailID");
		pwd = request.getParameter("inputPassword");
		opresult=proxy.signUp(email, pwd, fname, lname);
		
		session = request.getSession();
		
		if(opresult.substring(0,4).equals("true"))
		{
			session.setAttribute("userSession", session);
			request.getRequestDispatcher("SignIn.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("isUserExists",opresult);
			System.out.println("Error in Sign Up::"+request.getAttribute("isUserExists"));
			request.getRequestDispatcher("SignUp.jsp").forward(request, response);
		}
	}

}
