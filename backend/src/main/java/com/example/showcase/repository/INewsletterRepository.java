package com.example.showcase.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.showcase.model.Newsletter;

import jakarta.transaction.Transactional;

public interface INewsletterRepository extends JpaRepository<Newsletter, Long> {
	
	@Query("SELECT n.email FROM Newsletter n WHERE n.id = :id")
    String findEmailById(@Param("id") Long id);
	
	@Query("SELECT n.email FROM Newsletter n")
	List<String> findAllEmails();

    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO newsletter (email) VALUES (:email)", nativeQuery = true)
    int insertEmail(@Param("email") String email);

    List<Newsletter> findByEmail(String email);

}