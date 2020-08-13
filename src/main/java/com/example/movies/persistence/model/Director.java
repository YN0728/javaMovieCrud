package com.example.movies.persistence.model;

import javax.persistence.Entity;

@Entity
public class Director extends AbstractBaseEntity{

	private String name;
	private String surName;

	public Director(String name, String surName) {
		this.name = name;
		this.surName = surName;
	}

	public Director() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}
}
