package com.project.Blogify.domain;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



//Post bean class currently without category id:
@Entity
@Table(name = "Post")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",nullable = false, updatable = false)
	private long id;
	
//	@JsonIgnore
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "Category")
//	private Category category;
	
	
	@ManyToOne
	@JoinColumn(name = "Author")
	private User Author;
	
	@Column(name = "imageUrl",nullable = true)
	private String imageUrl;
	
	@Column(name="title",nullable = false)
	private String title;
	
	@Column(name="description", nullable = false)
	private String desc;
	
	@Column(name="content",columnDefinition = "TEXT", nullable = false)
	private String content;
	
	@Column(name="postdate",nullable = false)
	private Date date;
	
	
	public Post(User author, String title, String desc,
			String content) {
		super();
		Author = author;
		//this.imageUrl = Url;
		this.title = title;
		this.desc = desc;
		this.content = content;
		this.date = new Date(Calendar.getInstance().getTimeInMillis());
	}

	public Post() {
		super();
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@JsonIgnore
    public User getAuthor() {
        return Author;
    }

    public void setAuthor(User user) {
        this.Author = user;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", AuthorId=" + Author + ", title=" + title
				+ ", desc=" + desc + ", content=" + content + ", date=" + date
				+ "]";
	}
}
