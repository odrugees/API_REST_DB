package com.edu.poli.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.edu.poli.apirest.model.Book;
import com.edu.poli.apirest.model.Editorial;
import com.edu.poli.apirest.repository.BookRepository;
import com.edu.poli.apirest.repository.EditorialRepository;

@RestController 
@RequestMapping("/api/editorial/")
public class EditorialController {

	@Autowired
	private EditorialRepository editorialRepository;
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("/Editorials")
	public List<Editorial> getAllEditorials() {
		// The EditorialRepository is already injected and you can use it
		return editorialRepository.findAll();
	}
	
	@GetMapping("/Editorials/{nit}")
	public Editorial getEditorialById(@PathVariable String nit) { 
		Editorial Editorial =  editorialRepository.findById(nit).get();
		return Editorial;
	}
	
	@PostMapping("/Editorials")
	public Editorial createEditorial(@RequestBody Editorial Editorial) {
		return editorialRepository.save(Editorial);
	}

	@PutMapping("/Editorials/{nit}/{id}")
	public Editorial associate(@PathVariable String nit, @PathVariable Integer id) {
		
		Editorial editorial = editorialRepository.findById(nit).get();
		Book book =  bookRepository.findById(id).get();
		
		book.setEditorial(editorial);
		editorial.getBook().add(book);
		
		editorialRepository.save(editorial);
		bookRepository.save(book);
		return editorial;
	}

	@PutMapping("/Editorials/{nit}")
	public Editorial updateEditorial(@PathVariable String nit, @RequestBody Editorial EditorialNew) {
		Editorial Editorial = editorialRepository.findById(nit).get();

		Editorial.setNit(EditorialNew.getNit());
		Editorial.setName(EditorialNew.getName());
		Editorial.setAddress(EditorialNew.getAddress());
		
		editorialRepository.save(Editorial);
		return Editorial;
	}

	@DeleteMapping("/Editorials/{nit}")
	public Editorial deleteEditorial(@PathVariable String nit) {
		Editorial Editorial = editorialRepository.findById(nit).get();
		editorialRepository.deleteById(nit);
		return Editorial;
	}
}
