package com.example.movies.rest;

import com.example.movies.persistence.model.Director;
import com.example.movies.persistence.model.Movie;
import com.example.movies.persistence.repository.DirectorRepository;
import com.example.movies.persistence.repository.MovieRepository;
import com.example.movies.rest.converter.MovieConverter;
import com.example.movies.rest.model.CreateMovieRequestModel;
import com.example.movies.rest.model.MovieResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class MovieController {

	private final DirectorRepository directorRepository;
	private final MovieRepository movieRepository;

	public MovieController(DirectorRepository directorRepository, MovieRepository movieRepository) {
		this.directorRepository = directorRepository;
		this.movieRepository = movieRepository;
	}


	@PostMapping(value = "movies")
	public ResponseEntity<MovieResponseModel> create(@RequestBody CreateMovieRequestModel createRequest){
		Optional<Director> byId = directorRepository.findById(createRequest.getDirectorId());
		Movie movie = new Movie(createRequest.getName(), createRequest.getBudget(), byId.get());
		Movie savedMovie = movieRepository.save(movie);
		MovieResponseModel response = MovieConverter.convertToResponseModel(savedMovie);
		return ResponseEntity.ok(response);
	}

	@PutMapping(value = "movies/{id}")
	public ResponseEntity<MovieResponseModel> update(@PathVariable(value = "id") Long id, @RequestBody CreateMovieRequestModel updateMovie){
		Movie movie = movieRepository.findById(id).get();
		updateMovie(updateMovie, movie);
		Movie savedMovie = movieRepository.save(movie);
		return ResponseEntity.ok(MovieConverter.convertToResponseModel(savedMovie));
	}

	@GetMapping(value = "movies/{id}")
	public ResponseEntity<MovieResponseModel> getById(@PathVariable(value = "id") Long id){
		Movie movie = movieRepository.findById(id).get();
		return ResponseEntity.ok(MovieConverter.convertToResponseModel(movie));
	}

	@GetMapping(value = "movies")
	public ResponseEntity<List<MovieResponseModel>> getAll(){
		List<Movie> all = movieRepository.findAll();
		List<MovieResponseModel> converted = all.stream()
			.map(MovieConverter::convertToResponseModel)
			.collect(Collectors.toList());
		return ResponseEntity.ok(converted);

	}

	@DeleteMapping(value = "movies/{id}")
	public ResponseEntity<Boolean> deleteById(@PathVariable(value = "id") Long id){
		movieRepository.deleteById(id);
		return ResponseEntity.ok(!movieRepository.existsById(id));
	}

	private void updateMovie(CreateMovieRequestModel updateMovie, Movie movie){

		Director director = null;
		try {
			director = directorRepository.findById(updateMovie.getDirectorId()).get();
		}
		catch (Exception e){
			e.printStackTrace();
		}

		if(updateMovie.getName()==null) {
			movie.setName(movie.getName());
		} else {
			movie.setName(updateMovie.getName());
		}
		if(updateMovie.getBudget()==null) {
			movie.setBudget(movie.getBudget());
		} else {
			movie.setBudget(updateMovie.getBudget());
		}
		if(updateMovie.getDirectorId()==null){
			movie.setDirector(movie.getDirector());
		} else{
			movie.setDirector(director);
		}
	}




}
