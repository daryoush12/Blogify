package com.project.Blogify.domain;

public class ModifiableUserObject {
private long id;
private String Firstname;
private String Lastname;
private String username;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getFirstname() {
	return Firstname;
}
public void setFirstname(String firstname) {
	Firstname = firstname;
}
public String getLastname() {
	return Lastname;
}
public void setLastname(String lastname) {
	Lastname = lastname;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public ModifiableUserObject() {
	super();
	// TODO Auto-generated constructor stub
}
}
