package presentation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.Game;
import persistence.LeagueDAO;
import persistence.Team;

/**
 * Servlet implementation class UpcomingGameServlet
 */
@WebServlet("/UpcomingGame")
public class UpcomingGameServlet extends DerbyServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpcomingGameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Initialize local variables
				String url = "/UpcomingGames.jsp";		
				ServletContext ctx = getServletContext();
				
				//Attempt to get database connection, redirects to login page if no connection found
				getEntityManager(request, response);
				
				//If connection found, retrieve schedule data from DAO 
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
