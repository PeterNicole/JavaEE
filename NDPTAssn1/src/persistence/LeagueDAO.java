/**
 * @author Nicole Dahlquist & Peter Thomson
 * June 4, 2016
 * PROG3060 - NDPTAssn1
 * LeagueDAO.java
 * Retrieves persisted data from the LeagueDB Derby Database
 */
package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Retrieves persisted data from the LeagueDB Derby Database
 */
public class LeagueDAO {

	private Connection conn;
	
	public LeagueDAO(Connection conn){
		this.conn = conn;
	}
	
	// game queries
	private ArrayList<Game> getGames(PreparedStatement ps) throws SQLException{
		ArrayList<Game> games = new ArrayList<Game>();
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Game game = new Game();
			game.setGameID(rs.getInt("gameID"));
			game.setDate(rs.getDate("gamedate"));
			game.setArenaName(rs.getString("arenaName"));
			game.setHomeTeam(rs.getString("home"));
			game.setVisitorTeam(rs.getString("visitor"));
			game.setHomeScore(rs.getInt("homeScore"));
			game.setVisitorScore(rs.getInt("visitorScore"));			
			game.setOT(rs.getBoolean("OT")? "Y":"N");
			game.setSO(rs.getBoolean("SO")? "Y":"N");
			games.add(game);
		}
		rs.close();
		ps.close();		
		return games;
	}
	
	public ArrayList<Game> getGames(String teamID) throws SQLException{
		PreparedStatement ps = null;
		String query = "SELECT gameID, gamedate, a.arenaName, home, visitor, homeScore, visitorScore, OT, SO " 
				+ "FROM game g JOIN arena a "
				+ "ON g.arena = a.arenaID "
				+ "WHERE home = ? OR visitor = ?";
		ps = conn.prepareStatement(query);
		ps.setString(1, teamID);
		ps.setString(2, teamID);
		return getGames(ps);
	}
	
	public ArrayList<Game> getCompletedGames(String teamID) throws SQLException{
		PreparedStatement ps = null;
		String query = "SELECT gameID, gamedate, a.arenaName, t1.teamName as home, t2.teamName as visitor, homeScore, visitorScore, OT, SO " 
				+ "FROM game g JOIN arena a "
				+ "ON g.arena = a.arenaID "
				+ "JOIN team t1 "
				+ "ON g.home = t1.teamID "
				+ "JOIN team t2 "
				+ "ON g.visitor = t2.teamID "
				+ "WHERE (home = ? OR visitor = ?) AND homeScore IS NOT NULL AND visitorScore IS NOT NULL "
				+ "ORDER BY gamedate";
		ps = conn.prepareStatement(query);
		ps.setString(1, teamID);
		ps.setString(2, teamID);
		return getGames(ps);
	}
	
	public ArrayList<Game> getScheduledGames(String teamID) throws SQLException{
		PreparedStatement ps = null;
		String query = "SELECT gameID, gamedate, a.arenaName, t1.teamName as home, t2.teamName as visitor, homeScore, visitorScore, OT, SO " 
				+ "FROM game g JOIN arena a "
				+ "ON g.arena = a.arenaID "
				+ "JOIN team t1 "
				+ "ON g.home = t1.teamID "
				+ "JOIN team t2 "
				+ "ON g.visitor = t2.teamID "
				+ "WHERE (home = ? OR visitor = ?) AND homeScore IS NULL AND visitorScore IS NULL "
				+ "ORDER BY gamedate";
		ps = conn.prepareStatement(query);
		ps.setString(1, teamID);
		ps.setString(2, teamID);
		return getGames(ps);
	}
	
	// player queries
	public ArrayList<Player> getPlayers(String teamID) throws SQLException{
		ArrayList<Player> players = new ArrayList<Player>();
		PreparedStatement ps = null;
		String query = "SELECT playerID, lastName, firstName, r.jersey, r.position, height, weight, country "
				+ "FROM player p JOIN roster r "
				+ "ON p.playerID = r.player "
				+ "WHERE r.team = ?"
				+ "ORDER BY r.jersey";
		ps = conn.prepareStatement(query);
		ps.setString(1, teamID);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Player player = new Player();
			player.setPlayerID(rs.getInt("playerID"));
			player.setLastName(rs.getString("lastName"));
			player.setFirstName(rs.getString("firstName"));
			player.setJerseyNumber(rs.getInt("jersey"));
			player.setPosition(rs.getString("position"));
			player.setHeight(rs.getDouble("height"));
			player.setWeight(rs.getDouble("weight"));
			player.setCountry(rs.getString("country"));
			players.add(player);
		}
		rs.close();
		ps.close();
		return players;
	}
	
	// team queries
	public ArrayList<Team> getTeams() throws SQLException {
		ArrayList<Team> teams = new ArrayList<Team>();
		Statement stmt = null;
		String query = "SELECT t.teamID, l.leagueName, t.sponsor, t.teamName, t.website, "
				+ "s1.lastName as headLast, s1.firstName as headFirst, s2.lastName as asstLast, "
				+ "s2.firstName as asstFirst, s3.lastName as manLast, s3.firstName as manFirst " 
				+ "FROM team t JOIN league l "
				+ "ON t.league = l.leagueID "
				+ "JOIN staff s1 "
				+ "ON t.headCoach = s1.staffID "
				+ "JOIN staff s2 "
				+ "ON t.asstCoach = s2.staffID "
				+ "JOIN staff s3 "
				+ "ON t.manager = s3.staffID ";
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()){
			Team team = new Team();
			team.setTeamID(rs.getString("teamID"));
			team.setLeague(rs.getString("leagueName"));
			team.setSponsor(rs.getString("sponsor"));
			team.setName(rs.getString("teamName"));
			team.setWebsite(rs.getString("website"));
			team.setHeadCoach(rs.getString("headLast") + ", " + rs.getString("headFirst"));
			team.setAsstCoach(rs.getString("asstLast") + ", " + rs.getString("asstFirst"));
			team.setManager(rs.getString("manLast") + ", " + rs.getString("manFirst"));
			team.setWins(getWins(team.getTeamID()));
			team.setTies(getTies(team.getTeamID()));
			team.setLosses(getLosses(team.getTeamID()));
			teams.add(team);
		}
		rs.close();
		stmt.close();
		Collections.sort(teams);
		return teams;
	}
	
	// standings queries
	public int getWins(String teamID) throws SQLException{
		PreparedStatement ps = null;
		int wins =0;
		String query = "SELECT COUNT(*) FROM game g "
			+ "WHERE (home = ? AND homeScore > visitorScore) "
			+ "OR (visitor = ? AND visitorScore > homeScore) ";
		ps = conn.prepareStatement(query);
		ps.setString(1, teamID);
		ps.setString(2, teamID);
		ResultSet rs = ps.executeQuery();
		rs.next();
		wins = rs.getInt(1);
		return wins;
	}
	
	public int getLosses(String teamID) throws SQLException{
		PreparedStatement ps = null;
		int losses = 0;
		String query = "SELECT COUNT(*) FROM game g "
			+ "WHERE (home = ? AND homeScore < visitorScore) "
			+ "OR (visitor = ? AND visitorScore < homeScore) ";
		ps = conn.prepareStatement(query);
		ps.setString(1, teamID);
		ps.setString(2, teamID);
		ResultSet rs = ps.executeQuery();
		rs.next();
		losses = rs.getInt(1);
		return losses;
	}
	
	public int getTies(String teamID) throws SQLException{
		PreparedStatement ps = null;
		int ties = 0;
		String query = "SELECT COUNT(*) FROM game g "
			+ "WHERE (homeScore IS NOT NULL AND visitorScore IS NOT NULL) "
			+ "AND ((home = ? OR visitor = ?) AND homeScore = visitorScore) ";
		ps = conn.prepareStatement(query);
		ps.setString(1, teamID);
		ps.setString(2, teamID);
		ResultSet rs = ps.executeQuery();
		rs.next();
		ties = rs.getInt(1);
		return ties;
	}
}
