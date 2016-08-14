/**
 * PROG3060 - Assn3
 * Nicole Dahlquist & Peter Thomson
 * Created: July 12, 2016
 * PlayerStats Class - Represents a player's stats
 */
package persistence;

import javax.persistence.*;

@Entity
/**
 * Entity class for the PlayerStats table in the league database
 * @author Peter Thomson & Nicole Dahlquist
 *
 */
public class PlayerStats {
	
	//Class scope variables and constants
	private int statsId;
	private Player player;
	private Roster roster;
	private Schedule schedule;
	private Integer gp;
	private Integer goals;
	private Integer assists;
	private Integer plusMinus;
	private Integer pim;
	private Integer pp;
	private Integer sh;
	private Integer gwg;
	private Integer shots;
	private Integer shotPCT;
	private Integer suspensions;
	private Integer gaa;
	private Integer so;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getStatsId() {
		return statsId;
	}
	
	public void setStatsId(int statsId) {
		this.statsId = statsId;
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
	@JoinColumn(name="roster", nullable=false)
	public Roster getRoster() {
		return roster;
	}
	
	public void setRoster(Roster roster) {
		this.roster = roster;
	}
	
	@ManyToOne
	@JoinColumn(name="schedule", nullable=false)
	public Schedule getSchedule() {
		return schedule;
	}
	
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	
	public Integer getGp() {
		return gp;
	}
	
	public void setGp(Integer gp) {
		this.gp = gp;
	}
	
	public Integer getGoals() {
		return goals;
	}
	
	public void setGoals(Integer goals) {
		this.goals = goals;
	}
	
	public Integer getAssists() {
		return assists;
	}
	
	public void setAssists(Integer assists) {
		this.assists = assists;
	}
	
	public Integer getPlusMinus() {
		return plusMinus;
	}
	
	public void setPlusMinus(Integer plusMinus) {
		this.plusMinus = plusMinus;
	}
	
	public Integer getPim() {
		return pim;
	}
	
	public void setPim(Integer pim) {
		this.pim = pim;
	}
	
	public Integer getPp() {
		return pp;
	}
	
	public void setPp(Integer pp) {
		this.pp = pp;
	}
	
	public Integer getSh() {
		return sh;
	}
	
	public void setSh(Integer sh) {
		this.sh = sh;
	}
	
	public Integer getGwg() {
		return gwg;
	}
	
	public void setGwg(Integer gwg) {
		this.gwg = gwg;
	}
	
	public Integer getShots() {
		return shots;
	}
	
	public void setShots(Integer shots) {
		this.shots = shots;
	}
	
	public Integer getShotPCT() {
		return shotPCT;
	}
	
	public void setShotPCT(Integer shotPCT) {
		this.shotPCT = shotPCT;
	}
	
	public Integer getSuspensions() {
		return suspensions;
	}
	
	public void setSuspensions(Integer suspensions) {
		this.suspensions = suspensions;
	}
	
	public Integer getGaa() {
		return gaa;
	}
	
	public void setGaa(Integer gaa) {
		this.gaa = gaa;
	}
	
	public Integer getSo() {
		return so;
	}
	
	public void setSo(Integer so) {
		this.so = so;
	}
}
