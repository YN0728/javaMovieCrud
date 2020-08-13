package com.example.movies.rest.model;

public class CreateDirectorRequestModel {

	private String name;
	private String surName;

	public CreateDirectorRequestModel(String name, String surName) {
		this.name = name;
		this.surName = surName;
	}

	public CreateDirectorRequestModel() {
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
