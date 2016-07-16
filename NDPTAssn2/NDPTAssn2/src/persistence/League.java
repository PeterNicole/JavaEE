/**
 * PROG3060 - James Wong
 * Nicole Dahlquist & Peter Thomson
 * Created: July 2, 2016
 * League Class - Represents a league object from the LeagueDB
 */
package persistence;

import java.util.ArrayList;

import javax.persistence.*;

import org.hibernate.mapping.Set;

@Entity
public class League {

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
	
	@OneToMany(targetEntity=Team.class)
	@JoinColumn(name="league")
	public Set getTeams(){
		return teams;
	}
}