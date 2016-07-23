/**
 * @author Nicole Dahlquist & Peter Thomson
 * July 12, 2016
 * PROG3060 - NDPTAssn2
 * RosterServlet.java
 * Servlet for displaying team roster information on Roster.jsp
 */
package presentation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.LeagueDAO;
import persistence.Roster;
import persistence.Team;

/**
 * Servlet for displaying team roster information on Roster.jsp
 */
@WebServlet("/Roster")
public class RosterServlet extends DerbyServlet {
	private static final long serialVersionUID = 1L;       

	/**
	 * RosterServlet doGet method
	 * Retrieves information on the roster for a specific team
	 * @throws IOException 
	 * @throws ServletException 
	 */
    @Override 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//Initialize local variables
		String url = "/Roster.jsp";
		String teamID = request.getParameter("teamID");
		ServletContext ctx = getServletContext();		
		
		//Attempt to get a connection, redirects to login page if no connection found
		getEntityManagerFactory(request, response);
		
		//If connection to database exists, retrieve roster information from DAO object
		if(emf != null){
			LeagueDAO ldao = new LeagueDAO(emf);
			ArrayList<Roster> forwardRosters = new ArrayList<Roster>();
			ArrayList<Roster> defenceRosters = new ArrayList<Roster>();
			ArrayList<Roster> goalieRosters = new ArrayList<Roster>();
			Team team = new Team();
			try {
				 forwardRosters = ldao.getRosters(teamID, "Left Wing", "Right Wing", "Centre");
				 defenceRosters = ldao.getRosters(teamID, "Defence");
				 goalieRosters = ldao.getRosters(teamID, "Goalie");
				 team = ldao.getTeam(teamID);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			
			//Set roster and team name to be displayed on jsp
			request.setAttribute("forwardRosters", forwardRosters);
			request.setAttribute("defenceRosters", defenceRosters);
			request.setAttribute("goalieRosters", goalieRosters);
			request.setAttribute("team", team);
			ctx.getRequestDispatcher(url).forward(request, response);
		}
	}
}
