/**
 * @author Nicole Dahlquist & Peter Thomson
 * June 4, 2016
 * PROG3060 - NDPTAssn1
 * TeamServlet.java
 * Servlet for displaying Team information on Teams.jsp
 */
package presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.LeagueDAO;
import persistence.Team;

/**
 * Servlet for displaying Team information on Teams.jsp
 */
@WebServlet("/Team")
public class TeamServlet extends DerbyServlet {
	private static final long serialVersionUID = 1L;       

	/**
	 * TeamServlet doGet method
	 * Retrieves team data from database and displays it on Teams.jsp
	 */
    @Override 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//Initialize local variables
		String url = "/Teams.jsp";
		ServletContext ctx = getServletContext();	
		
		//Attempt to get connection to database, redirects to login page if no connection found
		getConnection(request, response);
		
		//If connection exists, retrieve team data from DAO and send it to jsp
		if(conn != null){
			LeagueDAO ldao = new LeagueDAO(conn);
			
			ArrayList<Team> teams = new ArrayList<Team>();
			try {
				teams = ldao.getTeams();			
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("teams", teams);
			ctx.getRequestDispatcher(url).forward(request, response);
		}
	}

}
