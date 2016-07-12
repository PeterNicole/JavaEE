/**
 * PROG3060 - James Wong
 * Nicole Dahlquist & Peter Thomson
 * Created: July 2, 2016
 * Game Class - Represents a game object from the LeagueDB
 */
package entities;

import java.sql.Time;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Game {

	private int gameId;
	private Schedule schedule;
	private Date gameDate;
	private Time gameTime;
	private Arena arena;
	private Team home;
	private Team visitor;
	private int homeScore;
	private int visitorScore;
	private String OT;
	private String SO;
	
	public int getGameId() {
		return gameId;
	}
	
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	
	public Schedule getSchedule() {
		return schedule;
	}
	
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	
	public Date getGameDate() {
		return gameDate;
	}
	
	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}
	
	public Time getGameTime() {
		return gameTime;
	}
	
	public void setGameTime(Time gameTime) {
		this.gameTime = gameTime;
	}
	
	public Arena getArena() {
		return arena;
	}
	
	public void setArena(Arena arena) {
		this.arena = arena;
	}
	
	public Team getHome() {
		return home;
	}
	
	public void setHome(Team home) {
		this.home = home;
	}
	
	public Team getVisitor() {
		return visitor;
	}
	
	public void setVisitor(Team visitor) {
		this.visitor = visitor;
	}
	
	public int getHomeScore() {
		return homeScore;
	}
	
	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}
	
	public int getVisitorScore() {
		return visitorScore;
	}
	
	public void setVisitorScore(int visitorScore) {
		this.visitorScore = visitorScore;
	}
	
	public String getOT() {
		return OT;
	}
	
	public void setOT(String oT) {
		OT = oT;
	}
	
	public String getSO() {
		return SO;
	}
	
	public void setSO(String sO) {
		SO = sO;
	}
	
}
