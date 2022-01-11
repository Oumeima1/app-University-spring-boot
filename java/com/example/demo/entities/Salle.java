package com.example.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Salle {
@Id @GeneratedValue
private long num_S;
private String nom_S;
private int  capacité;
@OneToMany(mappedBy="salle")
private List<Seance> SeanceList ;
public long getId() {
	return num_S;
}
public void setId(long num_S) {
	this.num_S = num_S;
}
public String getNom_S() {
	return nom_S;
}
public void setNom_S(String nom_S) {
	this.nom_S = nom_S;
}
public int getCapacité() {
	return capacité;
}
public void setCapacité(int capacité) {
	this.capacité = capacité;
}
public List<Seance> getSeanceList() {
	return SeanceList;
}
public void setSceanceList(List<Seance> seanceList) {
	SeanceList = seanceList;
}
   
	
}