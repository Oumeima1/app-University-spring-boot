package com.example.demo.DAO;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Etudiants;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface Etudiant1R extends JpaRepository<Etudiants, Long> {
	
	
}
