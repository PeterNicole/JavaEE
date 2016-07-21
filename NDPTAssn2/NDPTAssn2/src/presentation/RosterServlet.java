/**
 * @author Nicole Dahlquist & Peter Thomson
 * June 4, 2016
 * PROG3060 - NDPTAssn1
 * RosterServlet.java
 * Servlet for displaying team roster information on Roster.jsp
 */
package presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.LeagueDAO;
import persistence.Player;
import persistence.Roster;

/**
 * Servlet for displaying team roster information on Roster.jsp
 */
@WebServlet("/Roster")
public class RosterServlet extends DerbyServlet {
	private static final long serialVersionUID = 1L;       

	/**
	 * RosterServlet doGet method
	 * Retrieves information on the roster for a specific team
	 */
    @Override 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//Initialize local variables
		String url = "/Roster.jsp";
		String teamID = request.getParameter("teamID");
		String teamName = request.getParameter("teamName");
		ServletContext ctx = getServletContext();		
		
		//Attempt to get a connection, redirects to login page if no connection found
		getEntityManager(request, response);
		
		//If connection to database exists, retrieve roster information from DAO object
		if(emf != null){
			LeagueDAO ldao = new LeagueDAO(emf);
			ArrayList<Roster> rosters = new ArrayList<Roster>();
			try {
				rosters = ldao.getRosters(teamID);		
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			
			//Set roster and team name to be displayed on jsp
			request.setAttribute("rosters", rosters);
			request.setAttribute("teamName", teamName);
			ctx.getRequestDispatcher(url).forward(request, response);
		}
	}
}