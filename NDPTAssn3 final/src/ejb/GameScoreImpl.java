/**
 * @author Nicole Dahlquist & Peter Thomson
 * August 12, 2016
 * PROG3060 - NDPTAssn3
 * GameScoreImpl.java
 * EJB implementation of the GameScore interface
 */

package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

import persistence.Game;
import persistence.Team;



/**
 * Session Bean implementation class GameScoreImpl
 */
@Stateful
@LocalBean
/**
 * EJB implementation of the GameScore interface
 * @author Nicole Dahlquist & Peter Thomson
 *
 */
public class GameScoreImpl implements GameScore {

    /**
     * Default constructor. 
     */
    public GameScoreImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	/**
	 * Retrieves the score string for a specific game from the perspective of the specified team 
	 * i.e. 2-3(OT)
	 * @param team Team whose score will be displayed first in the score string
	 * @param game Game to retrieve score from
	 * @return game score as a string
	 */
	public String getScore(Team team, Game game) {
		String score = "";
		
		//Don't change the score string if the game is unplayed
		if(!(game.getVisitorScore()== 0 && game.getHomeScore() == 0)){			
			String id = team.getTeamId();
			
			//Team is visitor team
			if(game.getVisitor().getTeamId().equals(id)){
				score = game.getVisitorScore() + "-" + game.getHomeScore();	
			}
			
			//Team is home team
			else if(game.getHome().getTeamId().equals(id)){
				score = game.getHomeScore() + "-" + game.getVisitorScore();
			}
			
			//Game went to shootout
			if(game.getSO().equals("Y")){
				score += "(SO)";
			}
			
			//Game went to overtime
			else if(game.getOT().equals("Y")){
				score += "(OT)";
			}				
		}		
		
		return score;
	}
    
    

}
