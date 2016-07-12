/**
 * PROG3060 - James Wong
 * Nicole Dahlquist & Peter Thomson
 * Created: July 2, 2016
 * Schedule Class - Represents a schedule object from the LeagueDB
 */
package entities;

import javax.persistence.*;

@Entity
public class Schedule {

	private int scheduleId;
	private League league;
	private String season;
	private String scheduleName;
	private String sponsor;
	
	public int getScheduleId() {
		return scheduleId;
	}
	
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	
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
}
