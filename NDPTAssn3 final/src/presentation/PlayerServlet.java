/**
 * @author Nicole Dahlquist & Peter Thomson
 * July 12, 2016
 * PROG3060 - NDPTAssn3
 * PlayerServlet.java
 * Servlet class for displaying Player/Roster data on Player.jsp
 * 
 * Revised August 13, 2016: Now retrieves and outputs player stats for the specific roster
 */
package presentation;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.LeagueDAO;
import persistence.PlayerStats;
import persistence.Roster;

/**
 * 
 * @author Nicole Dahlquist & Peter Thomson
 * Servlet class for displaying Player/Roster data on Player.jsp
 * 
 */
@WebServlet("/Player")
public class PlayerServlet extends DerbyServlet {
	private static final long serialVersionUID = 1L;       

	/**
	 * doGet method for the player servlet
	 * Displays information for a specific player/roster
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//Initialize local variables
		String url = "/Player.jsp";
		ServletContext ctx = request.getServletContext();
		
		//Retrieve the roster data for the selected player on a specific team
		getEntityManagerFactory(request, response);
		if(emf != null)
		{
			LeagueDAO ldao = new LeagueDAO(emf);
			int rosterId = Integer.parseInt(request.getParameter("rosterId"));
			Roster roster = new Roster();
			PlayerStats stats = new PlayerStats();
			try {
				roster = ldao.getRoster(rosterId);
				
				//Note: we are making an assumption on which player stat to display 
				//due to the fact that there is only 1 schedule in the database.
				//The assignment did not specify, 
				//so it isn't possible for us to know precisely how to go about selecting a playerstat here
				stats = (PlayerStats) roster.getPlayerStats().iterator().next();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			
			//Set the roster attribute and forward the page
			request.setAttribute("roster", roster);
			request.setAttribute("stats", stats);
			ctx.getRequestDispatcher(url).forward(request, response);
		}		
	}

}
