package com.project.Blogify.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;






@Entity
@Table(name = "Users")
public class User {
	// Attributes:
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private long id;
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	@Column(name = "password", nullable = false)
	private String passwordHash;
	@Column(name = "role", nullable = false)
	private String role;
	@Column(name = "Firstname", nullable = false)
	private String Firstname;
	@Column(name = "Lastname", nullable = false)
	private String Lastname;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Author")
	private List<Post> Posts;

	// Constructors
	public User() {
		super();
	}

	public User(String username, String passwordHash, String role,
			String firstname, String lastname) {
		super();
		this.username = username;
		this.passwordHash = passwordHash;
		this.role = role;
		Firstname = firstname;
		Lastname = lastname;
	}

	// Getters and setters:
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
	@JsonIgnore
	public List<Post> getPosts() {
		return Posts;
	}

	public void setPosts(List<Post> posts) {
		Posts = posts;
	}
	
	
}
