package com.project.Blogify.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",nullable = false, updatable = false)
	private long id;
	@Column(name = "Category",nullable = false)
	private String category_value;
//	@OneToOne
//	@PrimaryKeyJoinColumn
//	private Post post;
	
	
//	public Post getPost() {
//		return post;
//	}
//	public void setPost(Post post) {
//		this.post = post;
//	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCategory_value() {
		return category_value;
	}
	public void setCategory_value(String category_value) {
		this.category_value = category_value;
	}
	
	
	
}
