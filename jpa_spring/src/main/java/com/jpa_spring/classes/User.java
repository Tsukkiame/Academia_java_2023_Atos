package com.jpa_spring.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Indica ao Hibernate criar uma tabela a partir da classe
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	// Lembrando que podemos usar a anotação para nomear a nossas colunas  dar algumas propriedades @Column (name="", nullable = false, unique = true, length = 50)
	private Integer id;
	@Column
	private String name;
	@Column
	private String email;
	
	//Getters & Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
