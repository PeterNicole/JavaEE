/**
 * PROG3060 - James Wong
 * Nicole Dahlquist & Peter Thomson
 * Created: July 2, 2016
 * Team Class - Represents a team object from the LeagueDB
 */
package persistence;

import java.util.ArrayList;

import javax.persistence.*;

import java.util.Set;

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
	private Set rosters;
	private Set homeGames;
	private Set visitorGames;
	
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
	@JoinColumn(name="headCoach", nullable=true)
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
	@JoinColumn(name="asstCoach", nullable=true)
	public Staff getAsstCoach() {
		return asstCoach;
	}
	
	public void setAsstCoach(Staff asstCoach) {
		this.asstCoach = asstCoach;
	}

	@ManyToOne
	@JoinColumn(name="manager", nullable=true)
	public Staff getManager() {
		return manager;
	}

	public void setManager(Staff manager) {
		this.manager = manager;
	}

	@ManyToOne
	@JoinColumn(name="trainer", nullable=true)
	public Staff getTrainer() {
		return trainer;
	}

	public void setTrainer(Staff trainer) {
		this.trainer = trainer;
	}

	@ManyToOne
	@JoinColumn(name="league", nullable=false)
	public League getLeague() {
		return league;
	}
	
	public void setLeague(League league) {
		this.league = league;
	}

	@OneToMany(targetEntity=Roster.class)
	//@JoinColumn(name="team")
	public Set getRosters(){
		return rosters;
	}
	
	public void setRosters(Set rosters){
		this.rosters = rosters;
	}
	
	@OneToMany(targetEntity=Game.class)
	@JoinColumn(name="home")
	public Set getHomeGames(){
		return homeGames;
	}
	
	public void setHomeGames(Set games){
		this.homeGames = games;
	}
	
	@OneToMany(targetEntity=Game.class)
	@JoinColumn(name="visitor")
	public Set getVisitorGames(){
		return visitorGames;
	}
	
	public void setVisitorGames(Set games){
		this.visitorGames = games;
	}
}