package com.example.movies.rest.converter;

import com.example.movies.persistence.model.Director;
import com.example.movies.rest.model.DirectorResponseModel;

public class DirectorConverter {

	public static DirectorResponseModel convertToResponseModel(Director director){
		return new DirectorResponseModel(director.getId(), director.getName(), director.getSurName());
	}
}
