package com.example.demo.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class specialites {
	@Id
	@GeneratedValue
	private Long Id_sepacialite;
	private String libelle_S;
	public Long getId_sepacialite() {
		return Id_sepacialite;
	}
	public void setId_sepacialite(Long id_sepacialite) {
		Id_sepacialite = id_sepacialite;
	}
	public String getLibelle_S() {
		return libelle_S;
	}
	public void setLibelle_S(String libelle_S) {
		this.libelle_S = libelle_S;
	}
	public specialites() {
		super();
		// TODO Auto-generated constructor stub
	}
	public specialites(Long id_sepacialite, String libelle_S) {
		super();
		Id_sepacialite = id_sepacialite;
		this.libelle_S = libelle_S;
	}
	@Override
	public String toString() {
		return "specialites [Id_sepacialite=" + Id_sepacialite + ", libelle_S=" + libelle_S + "]";
	}
	
	
	

}