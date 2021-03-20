package com.edu.poli.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.poli.apirest.model.Book;
import com.edu.poli.apirest.model.Chapter;
import com.edu.poli.apirest.model.Editorial;
import com.edu.poli.apirest.repository.BookRepository;
import com.edu.poli.apirest.repository.ChapterRepository;

@RestController 
@RequestMapping("/api/chapter/")
public class ChapterController {
	
	@Autowired
	private ChapterRepository chapterRepository;
	
	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/Chapters")
	public List<Chapter> getAllChapters() {
		return chapterRepository.findAll();
	}
	
	@GetMapping("/Chapters/{id}")
	public Chapter getChapterById(@PathVariable Integer id) { 
		Chapter chapter =  chapterRepository.findById(id).get();
		return chapter;
	}
	
	@PostMapping("/Chapters")
	public Chapter cretateChapter(@RequestBody Chapter chapter) {
		return chapterRepository.save(chapter);
	}
	
	@PutMapping("/Chapters/{idChapter}/{idBook}")
	public Book associate(@PathVariable Integer idChapter, @PathVariable Integer idBook) {
		
		Chapter chapter = chapterRepository.findById(idChapter).get();
		Book book =  bookRepository.findById(idBook).get();
		
		chapter.setBook(book);
		book.getChapter().add(chapter);
		
		chapterRepository.save(chapter);
		bookRepository.save(book);
		return book;
	}

	@PutMapping("/Chapters/{id}")
	public Chapter updateChapter(@PathVariable Integer id, @RequestBody Chapter ChapterNew) {
		Chapter chapter = chapterRepository.findById(id).get();

		chapter.setName(ChapterNew.getName());
		chapter.setPages(ChapterNew.getPages());
		
		chapterRepository.save(chapter);
		return chapter;
	}

	@DeleteMapping("/Chapters/{id}")
	public Chapter deleteChapter(@PathVariable Integer id) {
		Chapter chapter = chapterRepository.findById(id).get();
		chapterRepository.deleteById(id);
		return chapter;
	}
}
