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
import persistence.Player;
import persistence.Roster;
import persistence.Team;

/**
 * Servlet implementation class PlayerServlet
 */
@WebServlet("/Player")
public class PlayerServlet extends DerbyServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/Player.jsp";
		ServletContext ctx = request.getServletContext();
		getEntityManager(request, response);
		LeagueDAO ldao = new LeagueDAO(emf);
		int rosterId = Integer.parseInt(request.getParameter("rosterId"));
		Roster roster = new Roster();
		try {
			roster = ldao.getRoster(rosterId);			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("roster", roster);
		ctx.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
