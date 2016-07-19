/**
 * @author Nicole Dahlquist & Peter Thomson
 * June 4, 2016
 * PROG3060 - NDPTAssn1
 * LeagueDAO.java
 * Retrieves persisted data from the LeagueDB Derby Database
 */
package persistence;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;

/**
 * Retrieves persisted data from the LeagueDB Derby Database
 */
public class LeagueDAO {

	//Class scope variables
	
	private EntityManager em;
	//Transaction tx;
	
	
	/**
	 * Parameterized constructor for injection of connection
	 * @param conn connection to database
	 */
	public LeagueDAO(EntityManager em){
		this.em = em;
	}
	
	/**
	 * Retrieves a list of completed games for a particular team
	 * @param teamID id of team to retrieve completed games for
	 * @return ArrayList<Game> containing completed games for the specified team
	 * @throws SQLException
	 */
	public ArrayList<Game> getCompletedGames(String teamID){
		ArrayList<Game> games = new ArrayList<Game>();
		em.getTransaction().begin();
		games = (ArrayList<Game>)em.createQuery(
			"SELECT g FROM Game g WHERE homeScore IS NOT NULL AND visitorScore IS NOT NULL AND (home = :home OR visitor = :visitor)", 
			Game.class).setParameter("home", teamID).setParameter("visitor", teamID)
			.getResultList();
		return games;
	}
	
	/**
	 * Retrieves a list of scheduled games for a particular team
	 * @param teamID id of team to retrieve scheduled games for
	 * @return ArrayList<Game> containing scheduled games for the specified team
	 * @throws SQLException
	 */
	public ArrayList<Game> getScheduledGames(String teamID){
		
		return new ArrayList<Game>();
	}
	
	// player queries
	/**
	 * Retrieves a list of all players for a particular team
	 * @param teamID id of team to retrieve players for
	 * @return List<Player> containing all players on the team specified
	 * @throws SQLException
	 */
	public ArrayList<Player> getPlayers(String teamID){
		ArrayList<Player> players = new ArrayList<Player>();
		em.getTransaction().begin();
		players = (ArrayList<Player>)em.createQuery(
			"SELECT p,r,t FROM Player p JOIN p.roster r JOIN r.team WHERE t.teamID = :teamID", 
			Player.class).setParameter("teamID", teamID).getResultList();
		return players;
	}
	
	// team queries
	/**
	 * Retrieves a list of all teams in the database
	 * @return ArrayList<Team> containing all teams
	 * @throws SQLException
	 */
	public ArrayList<Team> getTeams() {
		ArrayList<Team> teams = new ArrayList<Team>();
		em.getTransaction().begin();
		teams = (ArrayList<Team>)em.createQuery("SELECT t FROM Team t ", Team.class).getResultList();
		return teams;
	}
	
	// standings queries
	/**
	 * Gets the total number of wins for a particular team
	 * @param teamID id of team to get number of wins for
	 * @return total number of wins
	 * @throws SQLException
	 */
	public int getWins(String teamID){
		
		return 0;
	}
	
	/**
	 * Gets the total number of losses for a particular team
	 * @param teamID id of team to get number of losses for
	 * @return total number of losses
	 * @throws SQLException
	 */
	public int getLosses(String teamID){
		
		return 0;
	}
	
	/**
	 * Gets the total number of ties for a particular team
	 * @param teamID id of team to get number of ties for
	 * @return total number of ties
	 * @throws SQLException
	 */
	public int getTies(String teamID){
		
		return 0;
	}
}