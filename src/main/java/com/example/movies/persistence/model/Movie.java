package com.example.movies.persistence.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Movie extends AbstractBaseEntity{


	private String name;
	private Long budget;
	@ManyToOne
	private Director director;

	public Movie() {
	}

	public Movie(String name, Long budget, Director director) {
		this.name = name;
		this.budget = budget;
		this.director = director;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
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
}
