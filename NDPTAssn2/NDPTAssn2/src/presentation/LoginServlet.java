/**
 * @author Nicole Dahlquist & Peter Thomson
 * June 4, 2016
 * PROG3060 - NDPTAssn1
 * LoginServlet.java
 * Servlet for handling log in requests to derby database
 */
package presentation;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	 *
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Initialize local variables
		String url = "/Login.jsp?error=true";
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		//Verify username and password, attempt to get derby connection if valid credentials
		try {
			if(userName.equals(USER) && password.equals(PASSWORD)){
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("leagueDB");
				em = emf.createEntityManager();
			}			
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		//Store connection in session variable if it exists
		if(em != null){		
			HttpSession session = request.getSession();
			session.setAttribute("entityManager", em);			
			url = "/Team";
		}
		
		//Redirect to login page if invalid credentials, otherwise redirect to team page
		response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + url));
	}
}
