package com.man.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Student")
public class StudentDto {

	public StudentDto() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public Univercity getUni() {
		return uni;
	}

	public void setUni(Univercity uni) {
		this.uni = uni;
	}

	
	@Column(name = "First_Name")
	private String firstName;

	@Column(name = "Last_Name")
	private String lastName;
	@Column(name = "Email")
	private String email;

	@OneToOne
	@JoinColumn(name = "Address_id", referencedColumnName = "id")
	private StudentAddressDto address;

	@ManyToOne
	@JoinColumn(name = "Univercity_fk", referencedColumnName = "id")
	private Univercity uni;

	@ManyToOne
	@JoinColumn(name = "ClassRoom_fk", referencedColumnName = "id")
	private ClassRoom room;
	public ClassRoom getRoom() {
		return room;
	}

	public void setRoom(ClassRoom room) {
		this.room = room;
	}

	public StudentAddressDto getAddress() {
		return address;
	}

	public void setAddress(StudentAddressDto address) {
		this.address = address;
	}

	StudentDto(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
