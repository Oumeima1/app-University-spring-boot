package com.example.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Enseignant {
@Id @GeneratedValue
private long matricule;
private String nom_ENS;
private String prenom_ENS;
private String adresse_ENS;
private String diplome;
@OneToMany(mappedBy="Enseignant")
private List<Seance> seanceList;
public long getMatricule() {
	return matricule;
}
public void setMatricule(long matricule) {
	this.matricule = matricule;
}
public String getNom_ENS() {
	return nom_ENS;
}
public void setNom_ENS(String nom_ENS) {
	this.nom_ENS = nom_ENS;
}
public String getPrenom_ENS() {
	return prenom_ENS;
}
public void setPrenom_ENS(String prenom_ENS) {
	this.prenom_ENS = prenom_ENS;
}
public String getAdresse_ENS() {
	return adresse_ENS;
}
public void setAdresse_ENS(String adresse_ENS) {
	this.adresse_ENS = adresse_ENS;
}
public String getDiplome() {
	return diplome;
}
public void setDiplome(String diplome) {
	this.diplome = diplome;
}
public List<Seance> getSeanceList() {
	return seanceList;
}
public void setSeanceList(List<Seance> seanceList) {
	this.seanceList = seanceList;
}

}
