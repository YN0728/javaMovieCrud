package com.example.movies.rest;

import com.example.movies.persistence.model.Director;
import com.example.movies.persistence.model.Movie;
import com.example.movies.persistence.repository.DirectorRepository;
import com.example.movies.persistence.repository.MovieRepository;
import com.example.movies.rest.converter.DirectorConverter;
import com.example.movies.rest.converter.MovieConverter;
import com.example.movies.rest.model.CreateDirectorRequestModel;
import com.example.movies.rest.model.CreateMovieRequestModel;
import com.example.movies.rest.model.DirectorResponseModel;
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
public class DirectorController {

	private final DirectorRepository directorRepository;

	public DirectorController(DirectorRepository directorRepository) {
		this.directorRepository = directorRepository;
	}


	@PostMapping(value = "director")
	public ResponseEntity<DirectorResponseModel> create(@RequestBody CreateDirectorRequestModel createRequest){
		Director director = new Director(createRequest.getName(), createRequest.getSurName());
		Director savedDirector = directorRepository.save(director);
		DirectorResponseModel response = DirectorConverter.convertToResponseModel(savedDirector);
		return ResponseEntity.ok(response);
	}

	@PutMapping(value = "director/{id}")
	public ResponseEntity<DirectorResponseModel> update(@PathVariable(value = "id") Long id, @RequestBody CreateDirectorRequestModel updateDirector){
		Director director = directorRepository.findById(id).get();
		updateDirector(updateDirector, director);
		Director savedDirector = directorRepository.save(director);
		return ResponseEntity.ok(DirectorConverter.convertToResponseModel(savedDirector));
	}

	@GetMapping(value = "director/{id}")
	public ResponseEntity<DirectorResponseModel> getById(@PathVariable(value = "id") Long id){
		Director director = directorRepository.findById(id).get();
		return ResponseEntity.ok(DirectorConverter.convertToResponseModel(director));
	}

	@GetMapping(value = "director")
	public ResponseEntity<List<DirectorResponseModel>> getAll(){
		List<Director> all = directorRepository.findAll();
		List<DirectorResponseModel> converted = all.stream()
			.map(DirectorConverter::convertToResponseModel)
			.collect(Collectors.toList());
		return ResponseEntity.ok(converted);
	}

	@DeleteMapping(value = "director/{id}")
	public ResponseEntity<Boolean> deleteById(@PathVariable(value = "id") Long id){
		directorRepository.deleteById(id);
		return ResponseEntity.ok(!directorRepository.existsById(id));
	}

	private void updateDirector(CreateDirectorRequestModel updateDirector, Director director){

		if(updateDirector.getName()==null) {
			director.setName(director.getName());
		} else {
			director.setName(director.getName());
		}
		if(updateDirector.getSurName()==null) {
			director.setSurName(director.getSurName());
		} else {
			director.setSurName(updateDirector.getSurName());
		}

	}




}
