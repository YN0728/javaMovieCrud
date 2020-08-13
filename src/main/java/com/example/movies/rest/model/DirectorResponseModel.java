package com.example.movies.rest.model;

public class DirectorResponseModel {

	private Long id;
	private String name;
	private String surName;

	public DirectorResponseModel(Long id, String name, String surName) {
		this.id = id;
		this.name = name;
		this.surName = surName;
	}

	public DirectorResponseModel() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
