package com.example.demo.entities;

import java.util.List;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/*@AllArgsConstructor
@NbArgsconstructor
@toString*/

@Entity
public class Universite {

@Getter 
@Setter
@Id @GeneratedValue	
private int code_UNIV;
private String nom_UNIV;
private String adresse_site; 
@OneToMany(mappedBy="uni")
private List<Departement> dept;
public String getNom_UNIV() {
	return nom_UNIV;
}
public void setNom_UNIV(String nom_UNIV) {
	this.nom_UNIV = nom_UNIV;
}
public String getAdr() {
	return adresse_site;
}
public void setAdr(String adresse_site) {
	this.adresse_site = adresse_site;
}

}
