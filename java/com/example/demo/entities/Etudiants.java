package com.example.demo.entities;

import java.util.Date;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
@Entity
public class Etudiants {
	@Id
	@GeneratedValue
	private Long IdE;
	private String nome;
	private int Niveau;
	private Date DateE;
	
	@ManyToOne 
	@JoinColumn(name="spec")
	private specialites st;
	
	@ManyToOne 
	@JoinColumn(name="dept")
	private Departement dt;
	
	private Double moyenne;

	public Long getIdE() {
		return IdE;
	}

	public void setIdE(Long idE) {
		IdE = idE;
	}

	public String getnome() {
		return nome;
	}

	public void setnome(String nomE) {
		this.nome = nomE;
	}

	public int getNiveau() {
		return Niveau;
	}

	public void setNiveau(int niveau) {
		Niveau = niveau;
	}

	public Date getDateE() {
		return DateE;
	}

	public void setDateE(Date dateE) {
		DateE = dateE;
	}

	public specialites getSt() {
		return st;
	}

	public void setSt(specialites st) {
		this.st = st;
	}

	public Departement getDt() {
		return dt;
	}

	public void setDt(Departement dt) {
		this.dt = dt;
	}

	public Double getMoyenne() {
		return moyenne;
	}

	public void setMoyenne(Double moyenne) {
		this.moyenne = moyenne;
	}

	public Etudiants() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Etudiants(String nomE, int niveau, Date dateE, specialites st, Departement dt, Double moyenne) {
		super();
		this.nome = nomE;
		this.Niveau = niveau;
		this.DateE = dateE;
		this.st = st;
		this.dt = dt;
		this.moyenne = moyenne;
	}

	@Override
	public String toString() {
		return "Etudiants [IdE=" + IdE + ", NomE=" + nome + ", Niveau=" + Niveau + ", DateE=" + DateE + ", st=" + st
				+ ", dt=" + dt + ", moyenne=" + moyenne + "]";
	}
	

}