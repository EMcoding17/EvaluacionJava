package com.evaluacion.parteuno.javaspring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * 
 * @author emma.romero
 *
 */
@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private long id_employee;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name="firstname")
	private String firstname;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_employee", referencedColumnName = "id_employee")
	private List<Language> language;
	
	@ManyToOne
	@JoinColumn(name="id_airport")
	private Airport airport;

	public long getId_employee() {
		return id_employee;
	}

	public void setId_employee(long id_employee) {
		this.id_employee = id_employee;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public List<Language> getLanguage() {
		return language;
	}

	public void setLanguage(List<Language> language) {
		this.language = language;
	}

	public Airport getAirport() {
		return airport;
	}

	public void setAirport(Airport airport) {
		this.airport = airport;
	}


}
