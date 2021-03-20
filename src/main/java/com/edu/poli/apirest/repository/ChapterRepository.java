package com.edu.poli.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.poli.apirest.model.Chapter;


public interface ChapterRepository extends JpaRepository<Chapter, Integer> {

}
