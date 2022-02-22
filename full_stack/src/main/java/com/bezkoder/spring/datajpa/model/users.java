package com.bezkoder.spring.datajpa.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "FIRST_NAME")
	private String firstname;

	@Column(name = "LAST_NAME")
	private String lastname;
	
	@Column(name = "classroom")
	private String classroom;
	
	@Column(name = "marks")
	private String marks;
	
	@Column(name = "subject")
	private String subject;	

	@Column(name = "EMAIL")
	private String email;

	public users() {

	}

	public users(String FIRST_NAME, String lastname, String email) {
		this.firstname = FIRST_NAME;
		this.lastname = lastname;
		this.classroom = classroom;
		this.marks = marks;
		this.subject = subject;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public String getFIRST_NAME() {
		return firstname;
	}

	public void setFIRST_NAME(String FIRST_NAME) {
		this.firstname = FIRST_NAME;
	}

	public String getLAST_NAME() {
		return lastname;
	}

	public void setLAST_NAME(String lastname) {
		this.lastname = lastname;
	}
	
	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String FIRST_NAME) {
		this.classroom = classroom;
	}
	
	public String getMarks() {
		return marks;
	}

	public void setMarks(String FIRST_NAME) {
		this.marks = marks;
	}
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String FIRST_NAME) {
		this.subject = subject;
	}

	public String getEMAIL() {
		return email;
	}

	public void setEMAIL(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "users [id=" + id + ", FIRST_NAME=" + firstname + ", lastname=" + lastname + ", email=" + email + "]";
	}

}
