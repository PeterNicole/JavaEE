/**
 * @author Nicole Dahlquist & Peter Thomson
 * June 4, 2016
 * PROG3060 - NDPTAssn1
 * DerbyServlet.java
 * Servlet superclass with getConnection method to be made available to all other servlets
 */
package presentation;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet superclass with getConnection method to be made available to all other servlets
 *
 */
public abstract class DerbyServlet extends HttpServlet {
	//Class scope variables and constants
	private static final long serialVersionUID = 1L;
	protected Connection conn;
	
	/**
	 * Attempts to retrieve derby connection from the session
	 * @param request Request object
	 * @param response Response object
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getConnection(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//Initialize local variables
		conn = null;
		HttpSession session = request.getSession();
		
		// attempt to get connection from session		
		conn = (Connection)session.getAttribute("conn");
		
		//Redirect to database log in page if no connection found
		if(conn == null){
			String url = "/Login.jsp";
			ServletContext ctx = getServletContext();	
			ctx.getRequestDispatcher(url).forward(request, response);
		}
	}
	
}
