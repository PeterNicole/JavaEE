/**
 * @author Nicole Dahlquist & Peter Thomson
 * July 12, 2016
 * PROG3060 - NDPTAssn3
 * ScheduleServlet.java
 * Servlet for displaying team schedule & game information on Schedule.jsp
 * 
 * Revised August 13, 2016: Added game score EJB to get the game score string
 */
package presentation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.GameScore;
import ejb.GameScoreImpl;
import persistence.Game;
import persistence.LeagueDAO;
import persistence.Team;

/**
 * Servlet for displaying team schedule & game information on Schedule.jsp
 */
@WebServlet("/Schedule")
public class ScheduleServlet extends DerbyServlet {
	private static final long serialVersionUID = 1L;       

	/**
	 * ScheduleServlet doGet method
	 * Retrieves schedule information from database and displays it on schedule.jsp
	 * @throws IOException 
	 * @throws ServletException 
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	//Initialize local variables
		String url = "/Schedule.jsp";
		String teamID = request.getParameter("teamID");
		Team team = new Team();
		GameScore gamescore = new GameScoreImpl();
		
		ServletContext ctx = getServletContext();
		
		//Attempt to get database connection, redirects to login page if no connection found
		getEntityManagerFactory(request, response);
		
		//If connection found, retrieve schedule data from DAO 
		if(emf != null){
			LeagueDAO ldao = new LeagueDAO(emf);
			ArrayList<Game> scheduledGames = new ArrayList<Game>();
			ArrayList<Game> completedGames = new ArrayList<Game>();
		
			try {
				scheduledGames = ldao.getScheduledGames(teamID);		
				completedGames = ldao.getCompletedGames(teamID);
				team = ldao.getTeam(teamID);
			}
			
			catch (Exception e) {
				e.printStackTrace();
			}
			
			//Use the EJB to get the game score for each game and set it as the score
			for(Game g : completedGames)
			{
				g.setScore(gamescore.getScore(team, g));
			}			
			
			//Set attributes with information to be displayed on jsp
			request.setAttribute("completedGames", completedGames);
			request.setAttribute("scheduledGames", scheduledGames);
			request.setAttribute("team", team);
			
			//Forward
			ctx.getRequestDispatcher(url).forward(request, response);
		}		
	}
}
