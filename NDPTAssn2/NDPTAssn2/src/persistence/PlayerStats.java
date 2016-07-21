/**
 * PROG3060 - Assn2
 * Nicole Dahlquist & Peter Thomson
 * Created: July 12, 2016
 * PlayerStats Class - Represents a player's stats
 */
package persistence;

import javax.persistence.*;

@Entity
public class PlayerStats {
	private int statsId;
	private Player player;
	private Roster roster;
	private Schedule schedule;
	private int gp;
	private int goals;
	private int assists;
	private int plusMinus;
	private int pim;
	private int pp;
	private int sh;
	private int gwg;
	private int shots;
	private int shotPCT;
	private int suspensions;
	private int gaa;
	private int so;
	
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
	
	public int getGp() {
		return gp;
	}
	
	public void setGp(int gp) {
		this.gp = gp;
	}
	
	public int getGoals() {
		return goals;
	}
	
	public void setGoals(int goals) {
		this.goals = goals;
	}
	
	public int getAssists() {
		return assists;
	}
	
	public void setAssists(int assists) {
		this.assists = assists;
	}
	
	public int getPlusMinus() {
		return plusMinus;
	}
	
	public void setPlusMinus(int plusMinus) {
		this.plusMinus = plusMinus;
	}
	
	public int getPim() {
		return pim;
	}
	
	public void setPim(int pim) {
		this.pim = pim;
	}
	
	public int getPp() {
		return pp;
	}
	
	public void setPp(int pp) {
		this.pp = pp;
	}
	
	public int getSh() {
		return sh;
	}
	
	public void setSh(int sh) {
		this.sh = sh;
	}
	
	public int getGwg() {
		return gwg;
	}
	
	public void setGwg(int gwg) {
		this.gwg = gwg;
	}
	
	public int getShots() {
		return shots;
	}
	
	public void setShots(int shots) {
		this.shots = shots;
	}
	
	public int getShotPCT() {
		return shotPCT;
	}
	
	public void setShotPCT(int shotPCT) {
		this.shotPCT = shotPCT;
	}
	
	public int getSuspensions() {
		return suspensions;
	}
	
	public void setSuspensions(int suspensions) {
		this.suspensions = suspensions;
	}
	
	public int getGaa() {
		return gaa;
	}
	
	public void setGaa(int gaa) {
		this.gaa = gaa;
	}
	
	public int getSo() {
		return so;
	}
	
	public void setSo(int so) {
		this.so = so;
	}
}
