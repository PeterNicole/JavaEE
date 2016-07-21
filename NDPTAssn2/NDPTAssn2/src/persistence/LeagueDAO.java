/**
 * @author Nicole Dahlquist & Peter Thomson
 * June 4, 2016
 * PROG3060 - NDPTAssn1
 * LeagueDAO.java
 * Retrieves persisted data from the LeagueDB Derby Database
 */
package persistence;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Retrieves persisted data from the LeagueDB Derby Database
 */
public class LeagueDAO {

	//Class scope variables
	
	private EntityManagerFactory emf;
	private EntityManager em;
	//Transaction tx;
	
	
	/**
	 * Parameterized constructor for injection of connection
	 * @param conn connection to database
	 */
	public LeagueDAO(EntityManagerFactory emf){
		this.emf = emf;
	}
	
	/**
	 * Retrieves a list of completed games for a particular team
	 * @param teamID id of team to retrieve completed games for
	 * @return ArrayList<Game> containing completed games for the specified team
	 */
	public ArrayList<Game> getCompletedGames(String teamID){
		ArrayList<Game> games = new ArrayList<Game>();
		em = emf.createEntityManager();
		em.getTransaction().begin();
		games = (ArrayList<Game>)em.createQuery(
			"SELECT g FROM Game g WHERE homeScore IS NOT NULL AND visitorScore IS NOT NULL "
			+ "AND (g.home.teamId = :home OR g.visitor.teamId = :visitor)", 
			Game.class).setParameter("home", teamID).setParameter("visitor", teamID)
			.getResultList();
		em.getTransaction().commit();
		em.close();
		return games;
	}
	
	/**
	 * Retrieves a list of scheduled games for a particular team
	 * @param teamID id of team to retrieve scheduled games for
	 * @return ArrayList<Game> containing scheduled games for the specified team
	 */
	public ArrayList<Game> getScheduledGames(String teamID){
		ArrayList<Game> games = new ArrayList<Game>();
		em = emf.createEntityManager();
		em.getTransaction().begin();
		games = (ArrayList<Game>)em.createQuery("SELECT g FROM Game g WHERE homeScore IS NULL "
			+ "AND visitorScore IS NULL AND (g.home.teamId = :home OR g.visitor.teamId = :visitor)",
		Game.class).setParameter("home", teamID).setParameter("visitor", teamID)
		.getResultList();
		em.close();
		return games;
	}
	
	// player queries
	/**
	 * Retrieves a list of all players for a particular team
	 * @param teamID id of team to retrieve players for
	 * @return List<Player> containing all players on the team specified
	 */
	public ArrayList<Roster> getRosters(String teamID){
		ArrayList<Roster> rosters = new ArrayList<Roster>();
		em = emf.createEntityManager();
		em.getTransaction().begin();
		rosters = (ArrayList<Roster>)em.createQuery(
			"SELECT r FROM Roster r WHERE r.team.teamId = :teamID", 
			Roster.class).setParameter("teamID", teamID).getResultList();
		em.getTransaction().commit();
		em.close();
		return rosters;
	}
	
	// team queries
	/**
	 * Retrieves a list of all teams in the database
	 * @return ArrayList<Team> containing all teams
	 */
	public ArrayList<Team> getTeams() {
		ArrayList<Team> teams = new ArrayList<Team>();
		em = emf.createEntityManager();
		em.getTransaction().begin();
		teams = (ArrayList<Team>)em.createQuery("SELECT t FROM Team t ", Team.class)
			.getResultList();
		em.getTransaction().commit();
		em.close();
		return teams;
	}
	
	// standings queries
	/**
	 * Gets the total number of wins for a particular team
	 * @param teamID id of team to get number of wins for
	 * @return total number of wins
	 */
	public int getWins(String teamID){
		
		return 0;
	}
	
	/**
	 * Gets the total number of losses for a particular team
	 * @param teamID id of team to get number of losses for
	 * @return total number of losses
	 */
	public int getLosses(String teamID){
		
		return 0;
	}
	
	/**
	 * Gets the total number of ties for a particular team
	 * @param teamID id of team to get number of ties for
	 * @return total number of ties
	 */
	public int getTies(String teamID){
		
		return 0;
	}
}