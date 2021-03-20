package com.edu.poli.apirest.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="book")
public class Book {
	
	@Id
	@Column(name="book_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int book_id;
	
	@Column(name="book_Author")
	private String author;
	
	@Column(name="book_cuontry")
	private String country;
	
	@Column(name="book_imageLink")
	private String imageLink;
	
	@Column(name="book_language")
	private String language;

	@Column(name="book_link")
	private String link;
	
	@Column(name="book_pages")
	private int pages;
	
	@Column(name="book_title")
	private String title;
	
	@Column(name="book_year")
	private int year;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="CD_ID")
	private CD cd;
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EDITORIAL_ID")
    @JsonIgnore
    private Editorial editorial;
    
	@OneToMany(mappedBy = "book")
	private Set<Chapter> chapter;
   
	public Book() {
		
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public CD getCd() {
		return cd;
	}

	public void setCd(CD cd) {
		this.cd = cd;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	public Set<Chapter> getChapter() {
		return chapter;
	}

	public void setChapter(Set<Chapter> chapter) {
		this.chapter = chapter;
	}

	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", author=" + author + ", country=" + country + ", imageLink=" + imageLink
				+ ", language=" + language + ", link=" + link + ", pages=" + pages + ", title=" + title + ", year="
				+ year + ", cd=" + cd + ", editorial=" + editorial + ", chapter=" + chapter + "]";
	}

	

	
}
