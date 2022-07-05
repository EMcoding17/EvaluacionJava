package com.evaluacion.parteuno.javaspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * 
 * @author emma.romero
 *
 */
@Entity
@Table(name="airport")
public class Airport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_airport;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="id_country")
	private Country country;

	public long getId_airport() {
		return id_airport;
	}

	public void setId_airport(long id_airport) {
		this.id_airport = id_airport;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
