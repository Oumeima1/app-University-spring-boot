package com.example.demo.DAO;

import org.springframework.stereotype.Repository;
import com.example.demo.entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SalleR extends JpaRepository<Salle, Long> {
	
	
}
