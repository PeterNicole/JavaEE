/**
 * @author Nicole Dahlquist & Peter Thomson
 * July 12, 2016
 * PROG3060 - NDPTAssn3
 * TeamServlet.java
 * Servlet for displaying team information on Teams.jsp
 * 
 * Revised August 13, 2016: Added EJB for getting next game string 
 */
package presentation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.NextGame;
import ejb.NextGameImpl;
import persistence.LeagueDAO;
import persistence.Schedule;
import persistence.Team;

/**
 * @author Nicole Dahlquist & Peter Thomson
 * Servlet for displaying team information on Teams.jsp
 */
@WebServlet("/Team")
public class TeamServlet extends DerbyServlet {
	private static final long serialVersionUID = 1L;   
    
	/**
	 * doGet method for the team servlet
	 * Displays information for all teams
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {		
		//Initialize local variables
		String url = "/Teams.jsp";
		ServletContext ctx = request.getServletContext();
		NextGame nextGame = new NextGameImpl();
		Schedule schedule = new Schedule();
		
		//Attempt to retrieve teams data
		getEntityManagerFactory(request, response);
		if(emf != null)
		{
			LeagueDAO ldao = new LeagueDAO(emf);
			ArrayList<Team> teams = new ArrayList<Team>();
			try {
				teams = ldao.getTeams();	
				schedule = ldao.getSchedules().get(0);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			
			//Get the next game string for each team using the EJB and set the next game property
			for(Team t: teams)
			{			
				t.setNextGame(nextGame.getNextGame(t, schedule, emf));
			}
			
			//Set teams attribute and forward
			request.setAttribute("teams", teams);
			ctx.getRequestDispatcher(url).forward(request, response);
		}		
	}
}
