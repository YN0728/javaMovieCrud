package com.example.movies.rest.model;

public class MovieResponseModel {

	private Long id;
	private String name;
	private Long budget;
	private DirectorResponseModel director;

	public MovieResponseModel(Long id, String name, Long budget, DirectorResponseModel director) {
		this.id = id;
		this.name = name;
		this.budget = budget;
		this.director = director;
	}

	public MovieResponseModel() {
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

	public Long getBudget() {
		return budget;
	}

	public void setBudget(Long budget) {
		this.budget = budget;
	}

	public DirectorResponseModel getDirector() {
		return director;
	}

	public void setDirector(DirectorResponseModel director) {
		this.director = director;
	}
}
