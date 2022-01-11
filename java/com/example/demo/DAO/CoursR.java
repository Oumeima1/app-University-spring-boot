package com.example.demo.DAO;



import org.springframework.stereotype.Repository;
import com.example.demo.entities.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CoursR extends JpaRepository<Cours, Long> {
	
	
}
