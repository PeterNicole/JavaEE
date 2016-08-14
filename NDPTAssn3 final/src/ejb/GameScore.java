/**
 * @author Nicole Dahlquist & Peter Thomson
 * August 12, 2016
 * PROG3060 - NDPTAssn3
 * GameScore.java
 * Interface for the GameScore EJB which contains the 'getScore' method
 */

package ejb;

import javax.ejb.Remote;

import persistence.Game;
import persistence.Team;

@Remote
/**
 * Interface for the GameScore EJB which contains the 'getScore' method
 * @author Nicole Dahlquist & Peter Thomson
 *
 */
public interface GameScore {

	/**
	 * Retrieves the score string for a specific game from the perspective of the specified team 
	 * i.e. 2-3(OT)
	 * @param team Team whose score will be displayed first in the score string
	 * @param game Game to retrieve score from
	 * @return game score as a string
	 */
	public String getScore(Team team, Game game);
}
