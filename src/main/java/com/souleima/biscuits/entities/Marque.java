package com.souleima.biscuits.entities;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Marque {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idMarque;
	
	private String nomMarque;
	private String descriptionMarque;
	
	
	@OneToMany (mappedBy = "marque")
	@JsonIgnore
	private List<Biscuit> biscuits;
	@Override
	public String toString() {
		return "Marque [idMarque=" + idMarque + ", nomMarque=" + nomMarque + ", descriptionMarque=" + descriptionMarque + "]";
	}

	public Long getIdMarque() {
		return idMarque;
	}

	public void setIdMarque(Long idMarque) {
		this.idMarque = idMarque;
	}

	public String getNomMarque() {
		return nomMarque;
	}

	public void setNomMarque(String nomMarque) {
		this.nomMarque = nomMarque;
	}

	public String getDescriptionMarque() {
		return descriptionMarque;
	}

	public void setDescriptionMarque(String descriptionMarque) {
		this.descriptionMarque = descriptionMarque;
	}
	
	
	
	
}
	

