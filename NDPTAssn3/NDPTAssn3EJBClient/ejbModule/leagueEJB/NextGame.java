package leagueEJB;

import javax.ejb.Remote;
import javax.persistence.EntityManagerFactory;

import persistence.Schedule;
import persistence.Team;

@Remote
public interface NextGame {

	public String getNextGame(Team team, Schedule schedule, EntityManagerFactory emf);
}
