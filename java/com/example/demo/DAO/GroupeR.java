package com.example.demo.DAO;

import org.springframework.stereotype.Repository;
import com.example.demo.entities.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface GroupeR extends JpaRepository<Groupe, Long> {
	
	
}