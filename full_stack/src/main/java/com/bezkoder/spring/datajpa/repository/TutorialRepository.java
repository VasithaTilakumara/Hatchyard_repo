package com.bezkoder.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.datajpa.model.users;

public interface TutorialRepository extends JpaRepository<users, Long> {
	//List<users> findByPublished(boolean published);
	//public List<users> findByTitleContaining(String FIRST_NAME);
	List<users> findByfirstnameContaining(String firstname);
}
