package com.evaluacion.parteuno.javaspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author emma.romero
 *
 */

@Entity
@Table(name="country")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_country;
	
	@Column(name="code")
	private int code;
	
	@Column(name="name")
	private String name;
		
	public long getId_country() {
		return id_country;
	}

	public void setId_country(long id_country) {
		this.id_country = id_country;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
}
