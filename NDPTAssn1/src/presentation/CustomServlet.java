/**
 * @author Nicole Dahlquist & Peter Thomson
 * June 4, 2016
 * PROG3060 - NDPTAssn1
 * CustomServlet.java
 * Servlet superclass
 */
package presentation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public abstract class CustomServlet extends HttpServlet {

	protected Connection getConnection(HttpServletRequest request, String userName, String password){
		Connection conn = null;
		HttpSession session = request.getSession();
		// attempt to get connection from session
		
		conn = (Connection)session.getAttribute("conn");
		if(conn == null){
			Properties connectionProps = new Properties();
			try {
				connectionProps.put("user", userName);
				connectionProps.put("password", password);
			
				conn = DriverManager.getConnection("jdbc:derby://localhost:1527/c:/Users/Nicole/DerbyLeagueDB/LeagueDB", connectionProps);
				//conn = DriverManager.getConnection("jdbc:derby://localhost:1527/G:/LeagueDB/leagueDB;", connectionProps);
				
				// save connection in session	
				session.setAttribute("conn", conn);
			}
			catch (Exception e){
				e.printStackTrace();			
			}
		}
		return conn;
	}
}
