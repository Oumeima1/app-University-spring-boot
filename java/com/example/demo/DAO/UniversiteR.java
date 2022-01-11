package com.example.demo.DAO;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UniversiteR extends JpaRepository<Universite, Long> {

}
