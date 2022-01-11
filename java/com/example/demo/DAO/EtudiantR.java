package com.example.demo.DAO;



import java.util.List;

import javax.websocket.server.PathParam;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.demo.entities.Etudiants;

@RepositoryRestResource
public interface EtudiantR extends JpaRepository<Etudiants, Long> {
	
	
	@RestResource(path = "/Q1")
	@Query("select e from Etudiants e order By e.DateE DESC")
	List<Etudiants> findByDateEDESC();

	@RestResource(path = "/Q2")

	List<Etudiants> findByNomeContainingAndNomeContaining(@PathParam("x") String x, @PathParam("y") String y);
    Page<Etudiants> findByNomeContaining(String x,Pageable pageable);
    /*
	@RestResource(path = "/Q3")
	@Query("select e.dt from Etudiants e where e.DateE=(select min(e.dateE) from Etudiants E)")
	List<Departement> dateemin();
	
	@RestResource(path = "/Q4")
	@Query("select AVG(e.moyenne) from Etudiants")
	double getAVG1();
	
	@RestResource(path = "/Q5")
	@Query("select e from Etudiant e where e.moyenne=((select max(t.moyenne) from Etudiant E where e.dt=t.dt))")
	double getAVG();
	
	@RestResource(path ="/Q7")
	@Query("select e.nom_dept ,COUNT(Etudiant) FROM Etudiant e")
	Collection<Object> NBDpt();//il faut l'appeler à partir du controlleur à cause du type de retour object
	
	//@RestResource(path="/Q8")
	//@Query("select dept.Nom_dept,count(*) as x from dept,etudiant where Etudiant.dt=dept.id group by Etudiant dept having")
	 @RestResource(path="/Q8")
	 @Query (value="select d from Departement d, Etudiant e where e.dt.ID_department=d.ID_department group by d.ID_department having count(e)=:x")
	 Collection<Departement> MoinsDept(@Param("x") Long x);
	 
	 @Query (value ="select Min(C) from (select count(dt) C from Etudiants  group by dt ) AS T"
	 , nativeQuery = true)
	 Long MoinsDept1();*/
}