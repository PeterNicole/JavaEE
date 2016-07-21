/**
 * @author Nicole Dahlquist & Peter Thomson
 * July 12, 2016
 * PROG3060 - NDPTAssn2
 * LoginServlet.java
 * Servlet for handling log in requests to derby database
 */
package presentation;

import java.io.IOException;

import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
/*
 * Servlet for handling log in requests to derby database
 */
public class LoginServlet extends DerbyServlet {
	
	//Class scope variables and constants
	final String USER = "gpaulley";
	final String PASSWORD = "derby";
		
	private static final long serialVersionUID = 1L;
	
	/**
	 * LoginServlet doPost method,
	 * Retrieves credentials from form and authenticates/establishes a connection to derby database
	 * @throws IOException 
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//Initialize local variables
		String url = "/Login.jsp?error=true";
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		//Verify username and password, attempt to get derby connection if valid credentials
		try {
			if(userName.equals(USER) && password.equals(PASSWORD)){
				emf = Persistence.createEntityManagerFactory("leagueDB");
			}			
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		//Store connection in application scope variable if it exists
		if(emf != null){		
			ServletContext applicationScope = request.getServletContext();
			applicationScope.setAttribute("entityManagerFactory", emf);			
			url = "/Team";
		}
		
		//Redirect to login page if invalid credentials, otherwise redirect to team page
		response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + url));
	}
}
