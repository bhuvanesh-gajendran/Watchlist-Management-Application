package com.example.watchlist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.watchlist.dao.MovieRepository;
import com.example.watchlist.model.Movies;

@Service
public class MoviesService {
	@Autowired
	private MovieRepository mrepo;
	
	public Movies saveMovie1(Movies m) {
		return mrepo.save(m);
	}
	
	public void saveMovie(Movies m) {
		mrepo.save(m);
	}
	public List<Movies> getAll(){
		return mrepo.findAll();	
	}
	public void DeleteMovie(Long id) {
		mrepo.deleteById(id);
	}
	public Optional<Movies> getThrough(Long wid){
		return mrepo.findById(wid);
	}
}
