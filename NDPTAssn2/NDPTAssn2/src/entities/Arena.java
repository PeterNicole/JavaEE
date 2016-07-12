/**
 * PROG3060 - James Wong
 * Nicole Dahlquist & Peter Thomson
 * Created: July 2, 2016
 * Arena Class - Represents a arena object from the LeagueDB
 */
package entities;

import javax.persistence.*;

@Entity
public class Arena {
	private int arenaId;
	private String arenaName;
	private String streetAddress;
	private String city;
	private String state_province;
	private String postalCode;
	private String country;
	private String phone;
	private int capacity;
	
	public int getArenaId() {
		return arenaId;
	}
	
	public void setArenaId(int arenaId) {
		this.arenaId = arenaId;
	}
	
	public String getArenaName() {
		return arenaName;
	}
	
	public void setArenaName(String arenaName) {
		this.arenaName = arenaName;
	}
	
	public String getStreetAddress() {
		return streetAddress;
	}
	
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState_province() {
		return state_province;
	}
	
	public void setState_province(String state_province) {
		this.state_province = state_province;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
