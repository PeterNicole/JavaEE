/**
 * @author Nicole Dahlquist & Peter Thomson
 * June 3, 2016
 * PROG3060 - NDPTAssn1
 * Team.java
 * Represents a team in the leagueDB
 *
 */
package persistence;

/**
 * Class representing a team in the leagueDB
 */
public class Team implements Comparable<Team>{

	//Class scope variables
	private String teamID;
	private String league;
	private String sponsor;
	private String name;
	private String website;
	private String headCoach;
	private String asstCoach;
	private String manager;
	private int wins;
	private int ties;
	private int losses;
	
	
	// getters and setters
	public String getTeamID() {
		return teamID;
	}
	public void setTeamID(String teamID) {
		this.teamID = teamID;
	}
	public String getLeague() {
		return league;
	}
	public void setLeague(String league) {
		this.league = league;
	}
	public String getSponsor() {
		return sponsor;
	}
	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getHeadCoach() {
		return headCoach;
	}
	public void setHeadCoach(String headCoach) {
		this.headCoach = headCoach;
	}
	public String getAsstCoach() {
		return asstCoach;
	}
	public void setAsstCoach(String asstCoach) {
		this.asstCoach = asstCoach;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	public int getTies() {
		return ties;
	}
	public void setTies(int ties) {
		this.ties = ties;
	}

	public int getLosses() {
		return losses;
	}
	public void setLosses(int losses) {
		this.losses = losses;
	}
	
	@Override
	/**
	 * Implementation of Comparable interface to allow easy sorting of teams by wins, losses, and ties
	 */
	public int compareTo(Team o) {
		int result = o.getWins() - wins;  // want sorted desc
		if(result == 0){
			result = o.getTies() - ties; // want sorted desc
		}
		if(result == 0){
			result = losses - o.getLosses();
		}
		return result;
	}	
}
