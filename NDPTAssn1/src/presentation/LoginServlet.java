/**
 * @author Nicole Dahlquist & Peter Thomson
 * June 4, 2016
 * PROG3060 - NDPTAssn1
 * CustomServlet.java
 * Servlet superclass
 */
package presentation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected Connection conn;
	
	protected void getConnection(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		conn = null;
		HttpSession session = request.getSession();
		// attempt to get connection from session
		
		conn = (Connection)session.getAttribute("conn");
		if(conn == null){
			String url = "/Login.jsp";
			ServletContext ctx = getServletContext();	
			ctx.getRequestDispatcher(url).forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String NDAHLQUIST = "ndahlquist";
		final String PASSWORD = "password";
		Properties connectionProps = new Properties();
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		connectionProps.put("user", userName);
		connectionProps.put("password", password);
		String url = "/Login.jsp";
		try {
			if(userName.equals(NDAHLQUIST) && password.equals(PASSWORD)){
				conn = DriverManager.getConnection("jdbc:derby://localhost:1527/c:/Users/Nicole/DerbyLeagueDB/LeagueDB", connectionProps);
			//conn = DriverManager.getConnection("jdbc:derby://localhost:1527/G:/LeagueDB/leagueDB;", connectionProps);
			}
			else {
				request.setAttribute("error", "Invalid login credentials");
			}
		} catch (SQLException e) {
			request.setAttribute("error", "Error connecting to database: " + e.getMessage());
		}
		
		if(conn != null){		
			HttpSession session = request.getSession();
			// save connection in session	
			session.setAttribute("conn", conn);	
			url = "/TeamServlet";
		}
		response.sendRedirect(response.encodeRedirectURL("/NDPTAssn1" + url));
	}
}
