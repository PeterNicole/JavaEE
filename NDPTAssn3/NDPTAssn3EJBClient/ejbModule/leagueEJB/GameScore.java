package leagueEJB;

import javax.ejb.Remote;

import persistence.Game;
import persistence.Team;

@Remote
public interface GameScore {

	public String getScore(Team team, Game game);
}