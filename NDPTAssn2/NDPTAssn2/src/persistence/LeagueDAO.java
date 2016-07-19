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
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

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
	 * Helper method which populates an ArrayList<Game> from a resultset of 
	 * games obtained from a prepared statement query 
	 *  
	 * @param ps prepared statement query expected to retrieve games from the database
	 * @return ArrayList<Game>
	 * @throws SQLException
	 */
	private ArrayList<Game> getGames(PreparedStatement ps) throws SQLException{
		ArrayList<Game> games = new ArrayList<Game>();
			
		return games;
	}
	
	/**
	 * Retrieves a list of completed games for a particular team
	 * @param teamID id of team to retrieve completed games for
	 * @return ArrayList<Game> containing completed games for the specified team
	 * @throws SQLException
	 */
	public ArrayList<Game> getCompletedGames(String teamID) throws SQLException{
		
		return new ArrayList<Game>();
	}
	
	/**
	 * Retrieves a list of scheduled games for a particular team
	 * @param teamID id of team to retrieve scheduled games for
	 * @return ArrayList<Game> containing scheduled games for the specified team
	 * @throws SQLException
	 */
	public ArrayList<Game> getScheduledGames(String teamID) throws SQLException{
		
		return new ArrayList<Game>();
	}
	
	// player queries
	/**
	 * Retrieves a list of all players for a particular team
	 * @param teamID id of team to retrieve players for
	 * @return List<Player> containing all players on the team specified
	 * @throws SQLException
	 */
	public ArrayList<Player> getPlayers(String teamID) throws SQLException{
		ArrayList<Player> players = new ArrayList<Player>();
		
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
	public int getWins(String teamID) throws SQLException{
		
		return 0;
	}
	
	/**
	 * Gets the total number of losses for a particular team
	 * @param teamID id of team to get number of losses for
	 * @return total number of losses
	 * @throws SQLException
	 */
	public int getLosses(String teamID) throws SQLException{
		
		return 0;
	}
	
	/**
	 * Gets the total number of ties for a particular team
	 * @param teamID id of team to get number of ties for
	 * @return total number of ties
	 * @throws SQLException
	 */
	public int getTies(String teamID) throws SQLException{
		
		return 0;
	}
}