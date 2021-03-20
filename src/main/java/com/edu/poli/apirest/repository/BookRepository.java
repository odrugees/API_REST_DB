package com.edu.poli.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.*;


import com.edu.poli.apirest.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	@Query ("FROM Book WHERE title like %?1%")
	List<Book> findByTitle(String title);
	
	@Query ("FROM Book WHERE pages >= 200 and pages <= 500")
	List<Book> findBynumberPage();
	
	@Query("FROM Book WHERE language = ?1")
	List<Book> findByLanguage(String language);	
}
