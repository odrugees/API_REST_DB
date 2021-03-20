package com.edu.poli.apirest.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="chapter")
public class Chapter {

	public Chapter () {

	}
	//Primary key
	@Id
	@Column(name="chapter_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int chapter_id;

	@Column(name="chapter_name")
	private String name;

	@Column(name="chapter_pages")
	private String pages;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    @JsonIgnore
    private Book book;

	public int getChapter_id() {
		return chapter_id;
	}

	public void setChapter_id(int chapter_id) {
		this.chapter_id = chapter_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Chapter [chapter_id=" + chapter_id + ", name=" + name + ", pages=" + pages + ", book=" + book + "]";
	}

	
}
