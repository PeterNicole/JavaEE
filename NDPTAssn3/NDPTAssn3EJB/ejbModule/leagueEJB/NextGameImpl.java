package leagueEJB;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManagerFactory;

import persistence.Schedule;
import persistence.Team;

/**
 * Session Bean implementation class NextGameImpl
 */
@Stateful
@LocalBean
public class NextGameImpl implements NextGame {

    /**
     * Default constructor. 
     */
    public NextGameImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String getNextGame(Team team, Schedule schedule,
			EntityManagerFactory emf) {
		// TODO Auto-generated method stub
		return null;
	}

}
