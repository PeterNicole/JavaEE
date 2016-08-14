/**
 * PROG3060 - Assn3
 * Nicole Dahlquist & Peter Thomson
 * Created: July 2, 2016
 * League Class - Represents a league object from the LeagueDB
 */
package persistence;

import javax.persistence.*;

import java.util.Set;

@Entity
/**
 * Entity class for the League table in the league database
 * @author Peter Thomson & Nicole Dahlquist
 *
 */
public class League {

	//Class scope variables and constants
	private String leagueId;
	private String leagueName;
	private String leagueSponsor;
	private Set schedules;
	private Set teams;

	@Id
	public String getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(String leagueId) {
		this.leagueId = leagueId;
	}

	@Column(nullable=false)
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

	@OneToMany(targetEntity=Schedule.class)
	@JoinColumn(name="league")
	public Set getSchedules(){
		return schedules;
	}
	
	public void setSchedules(Set schedules){
		this.schedules = schedules;
	}
	
	@OneToMany(targetEntity=Team.class)
	@JoinColumn(name="league")
	public Set getTeams(){
		return teams;
	}
	
	public void setTeams(Set teams){
		this.teams = teams;
	}
}
