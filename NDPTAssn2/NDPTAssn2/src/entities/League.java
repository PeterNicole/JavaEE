/**
 * PROG3060 - James Wong
 * Nicole Dahlquist & Peter Thomson
 * Created: July 2, 2016
 * League Class - Represents a league object from the LeagueDB
 */
package entities;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
public class League {

	private String leagueId;
	private String leagueName;
	private String leagueSponsor;

	@Id
	public String getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(String leagueId) {
		this.leagueId = leagueId;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public String getLeagueSponsor() {
		return leagueSponsor;
	}

	public void setLeagueSponsor(String leagueSponsor) {
		this.leagueSponsor = leagueSponsor;
	}

}
