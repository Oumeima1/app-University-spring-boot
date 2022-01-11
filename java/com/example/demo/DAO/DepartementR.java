package com.example.demo.DAO;

import org.springframework.stereotype.Repository;
import com.example.demo.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DepartementR extends JpaRepository<Departement, Long> {
	
	
}
