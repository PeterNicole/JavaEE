/**
 * @author Nicole Dahlquist & Peter Thomson
 * August 12, 2016
 * PROG3060 - NDPTAssn3
 * NextScore.java
 * Interface for the NextGame EJB containing the getNextGame method
 */

package ejb;

import javax.ejb.Remote;
import javax.persistence.EntityManagerFactory;

import persistence.Schedule;
import persistence.Team;

@Remote
/**
 * Interface for the NextGame EJB containing the getNextGame method
 * @author Nicole Dahlquist & Peter Thomson
 *
 */
public interface NextGame {

	/**
	 * Gets the string representing the date of the next game to be played for the specified team 
	 * on the specified schedule
	 * @param team Team to retrieve next game for
	 * @param schedule Schedule to retrieve next game from
	 * @param emf entity manager factory to be used for JPQL queries
	 * @return Next game date string i.e. "WED 11 FEB 2015"
	 */
	public String getNextGame(Team team, Schedule schedule, EntityManagerFactory emf);
}
