package com.edu.poli.apirest.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="editorial")
public class Editorial {
	
	//Primary key
	@Id
	@Column(name="NIT")
	private String nit;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Address")
	private String address;

	@OneToMany(mappedBy = "editorial")
    private Set<Book> books;
	
	public Editorial () {
		
	}
	public Editorial(String nit, String name, String address) {
		this.nit = nit;
		this.name = name;
		this.address = address;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Set<Book> getBook() {
		return books;
	}
	public void setBook(Set<Book> books) {
		this.books = books;
	}
}
