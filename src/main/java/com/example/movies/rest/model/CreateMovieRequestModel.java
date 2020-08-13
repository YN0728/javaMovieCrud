package com.example.movies.rest.model;

public class CreateMovieRequestModel {

	private String name;
	private Long budget;
	private Long directorId;

	public CreateMovieRequestModel(String name, Long budget, Long directorId) {
		this.name = name;
		this.budget = budget;
		this.directorId = directorId;
	}

	public CreateMovieRequestModel() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getBudget() {
		return budget;
	}

	public void setBudget(Long budget) {
		this.budget = budget;
	}

	public Long getDirectorId() {
		return directorId;
	}

	public void setDirectorId(Long directorId) {
		this.directorId = directorId;
	}
}
