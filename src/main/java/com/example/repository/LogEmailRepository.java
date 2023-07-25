package com.example.repository;

import com.example.entity.LogEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogEmailRepository extends JpaRepository<LogEmail, Long> {
	
}
