package com.entities;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NotesTaking {
	@Id
	private int id;
	@Column(length=500)
	private String title;
	@Column(length=5000)
	private String content;
	private Date date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public NotesTaking(String title, String content , Date date) {
		super();
		this.id = new Random().nextInt(10000);
		this.title = title;
		this.content = content;
		this.date = date;
	}
	public NotesTaking() {
		super();
	}
}
