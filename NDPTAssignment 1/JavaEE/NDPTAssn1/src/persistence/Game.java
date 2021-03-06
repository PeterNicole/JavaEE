/**
 * @author Nicole Dahlquist & Peter Thomson
 * June 3, 2016
 * PROG3060 - NDPTAssn1
 * Game.java
 * Represents a game in the leagueDB
 */
package persistence;

import java.sql.Date;

/**
 * Class representing a game in the leagueDB
 */
public class Game {

	//Class scope variables
	private int gameID;
	private String arenaName;
	private String homeTeam;
	private String visitorTeam;
	private int homeScore;
	private int visitorScore;
	private String OT;
	private String SO;
	private Date date;
	
	// getters and setters
	public int getGameID() {
		return gameID;
	}
	public void setGameID(int gameID) {
		this.gameID = gameID;
	}
	public String getArenaName() {
		return arenaName;
	}
	public void setArenaName(String arenaName) {
		this.arenaName = arenaName;
	}
	public String getHomeTeam() {
		return homeTeam;
	}
	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}
	public String getVisitorTeam() {
		return visitorTeam;
	}
	public void setVisitorTeam(String visitorTeam) {
		this.visitorTeam = visitorTeam;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}	
}
