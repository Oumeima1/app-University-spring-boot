package com.example.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Groupe {
@Id @GeneratedValue
private  long code_C;
private String libelle_C;
@OneToMany(mappedBy="groupe")
private List<Seance> seanceList;
/*@OneToMany(mappedBy="groupeEtu")
private List<Etudiant> etudiantList;*/
public long getId() {
	return code_C;
}
public void setId(long code_C) {
	this.code_C = code_C;
}
public String getLibelle_C() {
	return libelle_C;
}
public void setLibelle_C(String libelle_C) {
	this.libelle_C = libelle_C;
}
public List<Seance> getSeanceList() {
	return seanceList;
}
public void setSceanceList(List<Seance> seanceList) {
	this.seanceList = seanceList;
}
}