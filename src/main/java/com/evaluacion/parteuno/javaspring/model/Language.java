package com.evaluacion.parteuno.javaspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author emma.romero
 *
 */
@Entity
@Table(name="language")
public class Language {

	@Id
	@Column(nullable = false, unique = true)
	private long id_language;

	@Column(name="code", unique = true)
	private String code;
	
	@Column(name="name")
	private String name;

	public long getId_language() {
		return id_language;
	}

	public void setId_language(long id_language) {
		this.id_language = id_language;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



}