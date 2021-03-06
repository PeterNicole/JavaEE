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
	final String USER = "pjthomson";
	//final String USER = "ndahlquist";
	final String PASSWORD = "password";
	final String CONNECTION_STRING = "jdbc:derby://localhost:1527/C:/Users/Peter Thomson/Desktop/School/Courses/Spring 2016/PROG 3060/LeagueDB;";
	//final String CONNECTION_STRING = "jdbc:derby://localhost:1527/c:/Users/Nicole/DerbyLeagueDB/LeagueDB;";
	
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
		Properties connectionProps = new Properties();
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		connectionProps.put("user", userName);
		connectionProps.put("password", password);
		
		//Verify username and password, attempt to get derby connection if valid credentials
		try {
			if(userName.equals(USER) && password.equals(PASSWORD)){
			  conn = DriverManager.getConnection(CONNECTION_STRING, connectionProps);
			}			
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Store connection in session variable if it exists
		if(conn != null){		
			HttpSession session = request.getSession();
			session.setAttribute("conn", conn);			
			url = "/Team";
		}
		
		//Redirect to login page if invalid credentials, otherwise redirect to team page
		response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + url));
	}
}
