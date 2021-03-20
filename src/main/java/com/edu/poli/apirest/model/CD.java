package com.edu.poli.apirest.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cd")
public class CD {
	//Primary key
	@Id
	@Column(name="Serial")
	private String serial;

	@Column(name="Title")
	private String title;

	@Column(name="Version")
	private String version;

	@OneToOne(mappedBy = "cd")
	@JsonIgnore
	private Book book;

	public CD() {
	}
	public CD(String serial, String title, String version) {
		this.serial = serial;
		this.title = title;
		this.version = version;
	}

	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
}
