package com.edu.poli.apirest.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.edu.poli.apirest.model.Book;
import com.edu.poli.apirest.model.BookList;
import com.edu.poli.apirest.repository.BookRepository;

@RestController
@RequestMapping("/api/book/")
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/books")
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}

	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable Integer id){
		Book book = bookRepository.findById(id).get(); 
		return book;
	}

	@PostMapping("/books")
	public Book createBoook(@RequestBody Book book) {
		return bookRepository.save(book);
	}

	@PutMapping("/books/{id}")
	public Book updateBook(@PathVariable Integer id, @RequestBody Book bookNew) {
		Book bookdb = bookRepository.findById(id).get();

		bookdb.setAuthor(bookNew.getAuthor());
		bookdb.setCountry(bookNew.getCountry());
		bookdb.setImageLink(bookNew.getImageLink());
		bookdb.setLanguage(bookNew.getLanguage());
		bookdb.setLink(bookNew.getLink());
		bookdb.setPages(bookNew.getPages());
		bookdb.setTitle(bookNew.getTitle());
		bookdb.setYear(bookNew.getYear());

		bookRepository.save(bookdb);
		return bookdb;
	}

	@DeleteMapping("/books/{id}")
	public Book deleteBook(@PathVariable Integer id) {
		Book bookdb = bookRepository.findById(id).get();
		bookRepository.deleteById(id);
		return bookdb;
	}

	//Query
	@GetMapping("/booksTitle/{s}")
	public List<Book> getfindByTitle(@PathVariable String s) {
		return bookRepository.findByTitle(s);
	}
	
	//Query
	@GetMapping("/bookspage")
	public List<Book> findBynumberPage() {
		return bookRepository.findBynumberPage();
	}
	
	//Load List of Books
	@PostMapping("/booksL")
	public String createEmployeeList(@RequestBody BookList books) {

		for (Iterator<Book> iterator = books.getBooks().iterator(); iterator.hasNext();) {
			bookRepository.save(iterator.next());
		}

		return "done";
	}
	

}
