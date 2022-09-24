package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Author;

@Repository
public interface AuthorDAO extends JpaRepository<Author, Integer>{
	
	public Author findByName(String name);
}
