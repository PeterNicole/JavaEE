/**
 * @author Nicole Dahlquist & Peter Thomson
 * June 4, 2016
 * PROG3060 - NDPTAssn1
 * ScheduleServlet.java
 * Servlet for displaying team schedule & game information on Schedule.jsp
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
import persistence.Game;
import persistence.LeagueDAO;

/**
 * Servlet for displaying team schedule & game information on Schedule.jsp
 */
@WebServlet("/Schedule")
public class ScheduleServlet extends DerbyServlet {
	private static final long serialVersionUID = 1L;       

	/**
	 * ScheduleServlet doGet method
	 * Retrieves schedule information from database and displays it on schedule.jsp
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//Initialize local variables
		String url = "/Schedule.jsp";
		String teamID = request.getParameter("teamID");
		String teamName = request.getParameter("teamName");
		int wins = 0;
		int losses = 0;
		int ties = 0;
		ServletContext ctx = getServletContext();
		
		//Attempt to get database connection, redirects to login page if no connection found
		getConnection(request, response);
		
		//If connection found, retrieve schedule data from DAO 
		if(conn != null){
			LeagueDAO ldao = new LeagueDAO(conn);
			ArrayList<Game> scheduledGames = new ArrayList<Game>();
			ArrayList<Game> completedGames = new ArrayList<Game>();
		
			try {
				scheduledGames = ldao.getScheduledGames(teamID);		
				completedGames = ldao.getCompletedGames(teamID);
				wins = ldao.getWins(teamID);
				losses = ldao.getLosses(teamID);
				ties = ldao.getTies(teamID);
			}
			
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			//Set attributes with information to be displayed on jsp
			request.setAttribute("completedGames", completedGames);
			request.setAttribute("scheduledGames", scheduledGames);
			request.setAttribute("teamName", teamName);
			request.setAttribute("wins", wins);
			request.setAttribute("losses", losses);
			request.setAttribute("ties", ties);
			ctx.getRequestDispatcher(url).forward(request, response);
		}		
	}
}
