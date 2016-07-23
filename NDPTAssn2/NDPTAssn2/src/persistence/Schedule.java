/**
 * PROG3060 - Assn2
 * Nicole Dahlquist & Peter Thomson
 * Created: July 12, 2016
 * Schedule Class - Represents a schedule object from the LeagueDB
 */
package persistence;

import javax.persistence.*;

import java.util.Set;

@Entity
/**
 * Entity class for the Schedule table in the league database
 * @author Peter Thomson & Nicole Dahlquist
 *
 */
public class Schedule {

	//Class scope variables and constants
	private int scheduleId;
	private League league;
	private String season;
	private String scheduleName;
	private String sponsor;
	private Set games;
	private Set playerStats;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getScheduleId() {
		return scheduleId;
	}
	
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	
	@ManyToOne
	@JoinColumn(name="league", nullable=false)
	public League getLeague() {
		return league;
	}
	
	public void setLeague(League league) {
		this.league = league;
	}
	
	public String getSeason() {
		return season;
	}
	
	public void setSeason(String season) {
		this.season = season;
	}
	
	public String getScheduleName() {
		return scheduleName;
	}
	
	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}
	
	public String getSponsor() {
		return sponsor;
	}
	
	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}
	
	@OneToMany(targetEntity=Game.class)
	@JoinColumn(name="schedule")
	public Set getGames(){
		return games;
	}
	
	public void setGames(Set games){
		this.games = games;
	}
	
	@OneToMany(targetEntity=PlayerStats.class)
	@JoinColumn(name="schedule")
	public Set getPlayerStats(){
		return playerStats;
	}
	
	public void setPlayerStats(Set playerStats){
		this.playerStats = playerStats;
	}
}
