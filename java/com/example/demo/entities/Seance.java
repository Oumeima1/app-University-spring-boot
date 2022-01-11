package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Seance {
//@data
@Id  @GeneratedValue
private long id_Sceance;
private int durée;
@ManyToOne
private Groupe groupe;
@ManyToOne
private Salle salle;
@ManyToOne
private Cours Cour;
@ManyToOne
private Enseignant Enseignant;
public long getId() {
	return id_Sceance;
}
public void setId(long id_Sceance) {
	this.id_Sceance = id_Sceance;
}
public int getDurée() {
	return durée;
}
public void setDurée(int durée) {
	this.durée = durée;
}
public Groupe getGroupe() {
	return groupe;
}
public void setGroupe(Groupe groupe) {
	this.groupe = groupe;
}
public Salle getSalle() {
	return salle;
}
public void setSalle(Salle salle) {
	this.salle = salle;
}
public Cours getCour() {
	return Cour;
}
public void setCour(Cours cour) {
	Cour = cour;
}
public Enseignant getEnseignant() {
	return Enseignant;
}
public void setEnseignant(Enseignant enseignant) {
	Enseignant = enseignant;
}
	
}
