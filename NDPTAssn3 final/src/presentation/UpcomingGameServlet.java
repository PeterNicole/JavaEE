/**
 * @author Nicole Dahlquist & Peter Thomson
 * July 21, 2016
 * PROG3060 - NDPTAssn3
 * UpcomingGameServlet.java
 * Servlet for displaying upcoming game information on UpcomingGames.jsp
 */
package presentation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.Game;
import persistence.LeagueDAO;

/**
 * @author Nicole Dahlquist & Peter Thomson
 * Servlet for displaying upcoming game information on UpcomingGames.jsp
 */
@WebServlet("/UpcomingGame")
public class UpcomingGameServlet extends DerbyServlet {
	private static final long serialVersionUID = 1L;
       
	
	/**
	 * doGet method for the UpcomingGameServlet
	 * Displays information on all upcoming games
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//Initialize local variables
		String url = "/UpcomingGames.jsp";		
		ServletContext ctx = getServletContext();
		
		//Attempt to get database connection, redirects to login page if no connection found
		getEntityManagerFactory(request, response);
		
		//If connection found, retrieve upcoming games data from DAO 
		if(emf != null){
			LeagueDAO ldao = new LeagueDAO(emf);
			ArrayList<Game> upcomingGames = new ArrayList<Game>();
		
			try {
				upcomingGames = ldao.getUpcomingGames();	
			}
			
			catch (Exception e) {
				e.printStackTrace();
			}
			
			//Set attributes with information to be displayed on jsp
			request.setAttribute("upcomingGames", upcomingGames);
			ctx.getRequestDispatcher(url).forward(request, response);
		}
	}

}