/**
 * PROG3060 - James Wong
 * Nicole Dahlquist & Peter Thomson
 * Created: July 2, 2016
 * Game Class - Represents a game object from the LeagueDB
 */
package persistence;

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
	private Integer homeScore;
	private Integer visitorScore;
	private String OT;
	private String SO;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getGameId() {
		return gameId;
	}
	
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	
	@ManyToOne
	@JoinColumn(name="schedule", nullable=false)
	public Schedule getSchedule() {
		return schedule;
	}
	
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	
	@Column(nullable=false)
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
	
	@ManyToOne
	@JoinColumn(name="arena", nullable=false)
	public Arena getArena() {
		return arena;
	}
	
	public void setArena(Arena arena) {
		this.arena = arena;
	}
	
	@ManyToOne
	@JoinColumn(name="home", nullable=true)
	public Team getHome() {
		return home;
	}
	
	public void setHome(Team home) {
		this.home = home;
	}
	
	@ManyToOne
	@JoinColumn(name="visitor", nullable=true)
	public Team getVisitor() {
		return visitor;
	}
	
	public void setVisitor(Team visitor) {
		this.visitor = visitor;
	}
	
	@Column(nullable=true)
	public Integer getHomeScore() {
		return homeScore;
	}
	
	public void setHomeScore(Integer homeScore) {
		this.homeScore = homeScore;
	}
	
	@Column(nullable=true)
	public Integer getVisitorScore() {
		return visitorScore;
	}
	
	public void setVisitorScore(Integer visitorScore) {
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
