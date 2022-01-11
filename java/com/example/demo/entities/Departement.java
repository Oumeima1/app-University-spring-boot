package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor

@ToString
@Entity
public class Departement{
	
	@Id 
	@GeneratedValue
	private Long code_DEP;
	private String nom_DEP;
	 public Long getId() {
			return code_DEP;
		}
		public void setId(Long code_DEP) {
			this.code_DEP = code_DEP;
		}
	public String getNom_DEP() {
		return nom_DEP;
	}
	public void setNom_DEP(String nom_DEP) {
		this.nom_DEP = nom_DEP;
	}
    @ManyToOne
    private Universite uni;
    public Universite getUni() {
		return uni;
	}
	public void setUni(Universite uni) {
		this.uni = uni;
	}

}