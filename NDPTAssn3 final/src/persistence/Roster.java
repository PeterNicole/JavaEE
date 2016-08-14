/**
 * PROG3060 - Assn3
 * Nicole Dahlquist & Peter Thomson
 * Created: July 12, 2016
 * Roster Class - Represents a roster from the LeagueDB
 */
package persistence;

import javax.persistence.*;

import java.util.Set;

@Entity
/**
 * Entity class for the Roster table in the league database
 * @author Peter Thomson & Nicole Dahlquist
 *
 */
public class Roster {
	
	//Class scope variables and constants
	private int rosterId;
	private Player player;
	private Team team;
	private int jersey;
	private String position;
	private Set playerStats;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getRosterId() {
		return rosterId;
	}
	
	public void setRosterId(int rosterId) {
		this.rosterId = rosterId;
	}
	
	@ManyToOne
	@JoinColumn(name="player", nullable=false)
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	@ManyToOne
	@JoinColumn(name="team", nullable=false)
	public Team getTeam() {
		return team;
	}
	
	public void setTeam(Team team) {
		this.team = team;
	}
	
	public int getJersey() {
		return jersey;
	}
	
	public void setJersey(int jersey) {
		this.jersey = jersey;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	@OneToMany(targetEntity=PlayerStats.class)
	@JoinColumn(name="roster")
	public Set getPlayerStats(){
		return playerStats;
	}
	
	public void setPlayerStats(Set playerStats){
		this.playerStats = playerStats;
	}
}
