/**
 * @author Nicole Dahlquist & Peter Thomson
 * June 4, 2016
 * PROG3060 - NDPTAssn1
 * RosterServlet.java
 * Servlet implementation class RosterServlet
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

import persistence.LeagueDAO;
import persistence.Player;

/**
 * Servlet implementation class RosterServlet
 */
@WebServlet("/RosterServlet")
public class RosterServlet extends CustomServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RosterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/Roster.jsp";
		String teamID = request.getParameter("teamID");
		String teamName = request.getParameter("teamName");
		ServletContext ctx = getServletContext();		
		LeagueDAO ldao = new LeagueDAO(getConnection(request, "ndahlquist", "password"));
		ArrayList<Player> roster = new ArrayList<Player>();
		try {
			roster = ldao.getPlayers(teamID);		
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("roster", roster);
		request.setAttribute("teamName", teamName);
		ctx.getRequestDispatcher(url).forward(request, response);
	}
}
