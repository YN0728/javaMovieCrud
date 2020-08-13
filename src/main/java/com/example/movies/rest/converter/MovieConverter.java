package com.example.movies.rest.converter;

import com.example.movies.persistence.model.Movie;
import com.example.movies.rest.model.MovieResponseModel;

public class MovieConverter {

	public static MovieResponseModel convertToResponseModel(Movie movie){
		return new MovieResponseModel(movie.getId(), movie.getName(), movie.getBudget(), DirectorConverter.convertToResponseModel(movie.getDirector()));
	}
}
