package com.souleima.biscuits.entities;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
@Entity
public class Biscuit implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idBiscuit;
@NotNull
@Size (min = 4,max = 25)
private String nomBiscuit;
@Min(value = 10)
@Max(value = 10000)
private Double prixBiscuit;
@NotNull
@Size (min = 4,max = 25)
private String gout;
@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-MM-dd")
private Date dateSortir;

@ManyToOne
private Marque marque;

public Biscuit() {
	super();
}

public Biscuit(String nomBiscuit, Double prixBiscuit, Date dateSortir, String gout) {
	super();
	this.nomBiscuit = nomBiscuit;
	this.prixBiscuit = prixBiscuit;
	this.gout = gout;
	this.dateSortir = dateSortir;
	
}

public Long getIdBiscuit() {
	return idBiscuit;
}

public void setIdBiscuit(Long idBiscuit) {
	this.idBiscuit = idBiscuit;
}

public String getNomBiscuit() {
	return nomBiscuit;
}

public void setNomBiscuit(String nomBiscuit) {
	this.nomBiscuit = nomBiscuit;
}

public Double getPrixBiscuit() {
	return prixBiscuit;
}

public void setPrixBiscuit(Double prixBiscuit) {
	this.prixBiscuit = prixBiscuit;
}

public String getGout() {
	return gout;
}

public void setGout(String gout) {
	this.gout = gout;
}

public Date getDateSortir() {
	return dateSortir;
}

public void setDateSortir(Date dateSortir) {
	this.dateSortir = dateSortir;
}

@Override
public String toString() {
	return "Biscuit [idBiscuit=" + idBiscuit + ", nomBiscuit=" + nomBiscuit + ", prixBiscuit=" + prixBiscuit + ", gout="
			+ gout + ", dateSortir=" + dateSortir + "marque=" + marque +"]";
}
public Marque getMarque() {
	return marque;
}


public void setMarque(Marque marque) {
	this.marque = marque;
}
}