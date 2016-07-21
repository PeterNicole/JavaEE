package presentation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.LeagueDAO;
import persistence.Team;

/**
 * Servlet implementation class TeamServlet
 */
@WebServlet("/Team")
public class TeamServlet extends DerbyServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
   
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/Teams.jsp";
		ServletContext ctx = request.getServletContext();
		getEntityManager(request, response);
		LeagueDAO ldao = new LeagueDAO(emf);
		
		ArrayList<Team> teams = new ArrayList<Team>();
		try {
			teams = ldao.getTeams();			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("teams", teams);
		ctx.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
