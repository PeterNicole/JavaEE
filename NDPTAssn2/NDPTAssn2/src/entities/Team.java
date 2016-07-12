/**
 * PROG3060 - James Wong
 * Nicole Dahlquist & Peter Thomson
 * Created: July 2, 2016
 * Team Class - Represents a team object from the LeagueDB
 */
package entities;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
public class Team {
		
	private String teamId;
	private League league;
	private String teamName;
	private Staff headCoach;
	private Staff asstCoach;
	private Staff trainer;
	private Staff manager;
	private String sponsor;
	private String website;
	
	@Id
	public String getTeamId() {
		return teamId;
	}
	
	public void setTeamId(String teamID) {
		this.teamId = teamID;
	}
	
	public String getTeamName() {
		return teamName;
	}
	
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	@ManyToOne
	public Staff getHeadCoach() {
		return headCoach;
	}
	
	public void setHeadCoach(Staff headCoach) {
		this.headCoach = headCoach;
	}

	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@ManyToOne
	public Staff getAsstCoach() {
		return asstCoach;
	}
	
	public void setAsstCoach(Staff asstCoach) {
		this.asstCoach = asstCoach;
	}

	@ManyToOne
	public Staff getManager() {
		return manager;
	}

	public void setManager(Staff manager) {
		this.manager = manager;
	}

	@ManyToOne
	public Staff getTrainer() {
		return trainer;
	}

	public void setTrainer(Staff trainer) {
		this.trainer = trainer;
	}

	@ManyToOne
	//@JoinColumn(name="league")
	public League getLeague() {
		return league;
	}
	
	public void setLeague(League league) {
		this.league = league;
	}

}
