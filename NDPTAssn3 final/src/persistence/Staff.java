/**
 * PROG3060 - Assn3
 * Nicole Dahlquist & Peter Thomson
 * Created: July 12, 2016
 * Staff Class - Represents a staff object from the LeagueDB
 */
package persistence;

import javax.persistence.*;

import java.util.Set;

@Entity
/**
 * Entity class for the Staff table in the league database
 * @author Peter Thomson & Nicole Dahlquist
 *
 */
public class Staff {
	
	//Class scope variables and constants
	private String staffID;
	private String lastName;
	private String firstName;
	private String streetAddress;
	private String city;
	private String state_province;
	private String postalCode;
	private String country;
	private String phone;
	private String mobile;
	private String email;
	private String certification;
	private Set headCoachTeams;
	private Set asstCoachTeams;
	private Set trainerTeams;
	private Set managerTeams;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public String getStaffID() {
		return staffID;
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}

	@Column(nullable=false)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(nullable=false)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String cerification) {
		this.certification = cerification;
	}
	
	@OneToMany(targetEntity=Team.class)
	@JoinColumn(name="headCoach")
	public Set getHeadCoachTeams(){
		return headCoachTeams;
	}
	
	public void setHeadCoachTeams(Set staff){
		this.headCoachTeams = staff;
	}
	
	@OneToMany(targetEntity=Team.class)
	@JoinColumn(name="asstCoach")
	public Set getAsstCoachTeams(){
		return asstCoachTeams;
	}
	
	public void setAsstCoachTeams(Set staff){
		this.asstCoachTeams = staff;
	}
	
	@OneToMany(targetEntity=Team.class)
	@JoinColumn(name="manager")
	public Set getManagerTeams(){
		return managerTeams;
	}
	
	public void setManagerTeams(Set staff){
		this.managerTeams = staff;
	}
	
	@OneToMany(targetEntity=Team.class)
	@JoinColumn(name="trainer")
	public Set getTrainerTeams(){
		return trainerTeams;
	}
	
	public void setTrainerTeams(Set staff){
		this.trainerTeams = staff;
	}
}
