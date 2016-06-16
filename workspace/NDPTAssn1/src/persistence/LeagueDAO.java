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

/**
 * Retrieves persisted data from the LeagueDB Derby Database
 */
public class LeagueDAO {

	private Connection conn;
	
	public LeagueDAO(Connection conn){
		this.conn = conn;
	}
	
	public ArrayList<Game> getGames(String teamID) throws SQLException{
		ArrayList<Game> games = new ArrayList<Game>();
		PreparedStatement ps = null;
		String query = "SELECT gameID, a.arenaName, home, visitor, homeScore, visitorScore, OT, SO " 
				+ "FROM game g JOIN arena a "
				+ "ON g.arena = a.arenaID "
				+ "WHERE home = ? OR visitor = ?";
		ps = conn.prepareStatement(query);
		ps.setString(1, teamID);
		ps.setString(2, teamID);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Game game = new Game();
			game.setGameID(rs.getInt("gameID"));
			game.setArenaName(rs.getString("arenaName"));
			game.setHomeTeam(rs.getString("home"));
			game.setVisitorTeam(rs.getString("visitor"));
			game.setHomeScore(rs.getInt("homeScore"));
			game.setVisitorScore(rs.getInt("visitorScore"));
			game.setOT(rs.getBoolean("OT"));
			game.setSO(rs.getBoolean("SO"));
			games.add(game);
		}
		rs.close();
		ps.close();		
		return games;
	}
	
	public ArrayList<Player> getPlayers(String teamID) throws SQLException{
		ArrayList<Player> players = new ArrayList<Player>();
		PreparedStatement ps = null;
		String query = "SELECT playerID, lastName, firstName, r.jersey, r.position, height, weight, country "
				+ "FROM player p JOIN roster r "
				+ "ON p.playerID = r.player "
				+ "WHERE r.team = ?";
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
				+ "ON t.manager = s3.staffID "
				+ "ORDER BY t.teamName";
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
			teams.add(team);
		}
		rs.close();
		stmt.close();
		return teams;
	}
//	if(homeScore == visitorScore){
//		ties++;
//	}
//	if(homeTeam == id){
//		if(homeScore > visitorScore){
//			wins++;
//		}
//		else{
//			losses++;
//		}
//	}
//	else if (visitorTeam == id){
//		if(visitorScore > homeScore){
//			wins++;
//		}
//		else{
//			losses++;
//		}
//	}
}
