package com.example.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Cours {

@Id @GeneratedValue	
private  long code_C;
private String libelle_C;
@OneToMany(mappedBy="Cour")
private List<Seance> seanceList;
//public void setId(long id) {
	// TODO Auto-generated method stub
public long getId() {
	return code_C;
}
public void setId(long id) {
	this.code_C = id;
}
public String getLibelle_C() {
	return libelle_C;
}
public void setLibelle_C(String libelle_C) {
	this.libelle_C = libelle_C;
}
public List<Seance> getSceanceList() {
	return seanceList;
}
public void setSceanceList(List<Seance> seanceList) {
	this.seanceList = seanceList;
}
	


}
