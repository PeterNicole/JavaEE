/**
 * @author Nicole Dahlquist & Peter Thomson
 * June 4, 2016
 * PROG3060 - NDPTAssn1
 * ScheduleServlet.java
 * Servlet implementation class ScheduleServlet
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

import persistence.Game;
import persistence.LeagueDAO;

/**
 * Servlet implementation class ScheduleServlet
 */
@WebServlet("/ScheduleServlet")
public class ScheduleServlet extends LoginServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/Schedule.jsp";
		String teamID = request.getParameter("teamID");
		String teamName = request.getParameter("teamName");
		int wins = 0;
		int losses = 0;
		int ties = 0;
		ServletContext ctx = getServletContext();		
		getConnection(request, response);
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
				request.setAttribute("error", "Error loading data: " + e.getMessage());
			}
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
