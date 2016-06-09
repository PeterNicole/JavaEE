/**
 * @author Nicole Dahlquist & Peter Thomson
 * June 4, 2016
 * PROG3060 - NDPTAssn1
 * TeamServlet.java
 * Servlet implementation class TeamServlet
 */
package presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/TeamServlet")
public class TeamServlet extends CustomServlet {
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
		ServletContext ctx = getServletContext();		
		LeagueDAO ldao = new LeagueDAO(getConnection(request, "ndahlquist", "password"));
		ArrayList<Team> teams = new ArrayList<Team>();
		try {
			teams = ldao.getTeams();			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("teams", teams);
		ctx.getRequestDispatcher(url).forward(request, response);
	}

}