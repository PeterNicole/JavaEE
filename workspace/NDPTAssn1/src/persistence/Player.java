/**
 * @author Nicole Dahlquist & Peter Thomson
 * June 3, 2016
 * PROG3060 - NDPTAssn1
 * Player.java
 * Represents a player in the leagueDB
 */
package persistence;

/**
 * Class representing a player in the leagueDB
 */
public class Player {

	private int playerID;
	private String lastName;
	private String firstName;
	private int jerseyNumber;
	private String position;
	private double height;
	private double weight;
	private String country;
	
	//getters and setters
	public int getPlayerID() {
		return playerID;
	}
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getJerseyNumber() {
		return jerseyNumber;
	}
	public void setJerseyNumber(int jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	
}
