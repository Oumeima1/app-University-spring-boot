package com.example.demo.DAO;
import org.springframework.stereotype.Repository;
import com.example.demo.entities.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SeanceR extends JpaRepository<Seance, Long> {

}
