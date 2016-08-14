/**
 * @author Nicole Dahlquist & Peter Thomson
 * August 12, 2016
 * PROG3060 - NDPTAssn3
 * NextScoreImpl.java
 * EJB implementation of the NextGame interface
 */
package ejb;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import persistence.Game;
import persistence.Schedule;
import persistence.Team;

/**
 * Session Bean implementation class NextGameImpl
 */
@Stateful
@LocalBean
/**
 * EJB implementation of the NextGame interface
 * @author Peter Thomson
 *
 */
public class NextGameImpl implements NextGame {

	//Class scope variables and constants
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public NextGameImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	/**
	 * Gets the string representing the date of the next game to be played for the specified team 
	 * on the specified schedule
	 * @param team Team to retrieve next game for
	 * @param schedule Schedule to retrieve next game from
	 * @param emf entity manager factory to be used for JPQL queries
	 * @return Next game date string i.e. "WED 11 FEB 2015"
	 */
	public String getNextGame(Team team, Schedule schedule,
			EntityManagerFactory emf) {
		String date = "No games remaining";
		ArrayList<Game> games = new ArrayList<Game>();
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//Retrieve all incomplete games from the specified schedule for the team
		//Ordered by gamedate ascending (next game at position 0)
		games = (ArrayList<Game>)em.createQuery("SELECT g FROM Game g "
			+ "WHERE homeScore IS NULL AND visitorScore IS NULL "
			+ "AND (g.home.teamId = :home OR g.visitor.teamId = :visitor) "
			+ "AND g.schedule.scheduleId = :scheduleId "
			+ "ORDER BY g.gameDate", 
			Game.class).setParameter("home", team.getTeamId()).setParameter("visitor", team.getTeamId())
			.setParameter("scheduleId", schedule.getScheduleId())
			.getResultList();
		
		//Get the next game if it exists and set the string accordingly
		if(games.size() != 0){
			Game nextGame = games.get(0);
			DateFormat df = new SimpleDateFormat("EEE dd MMM yyyy");
			date = df.format(nextGame.getGameDate()).toUpperCase();
		}
		em.close();
		
		return date;
	}

}
