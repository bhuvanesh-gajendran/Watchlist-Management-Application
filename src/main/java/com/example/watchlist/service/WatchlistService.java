package com.example.watchlist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.watchlist.dao.WatchlistRepository;
import com.example.watchlist.model.Watchlist;

@Service
public class WatchlistService {
	@Autowired
	private WatchlistRepository repo;
	
	public void saveMovie(Watchlist w) {
		repo.save(w);
	}
	public Watchlist saveWatchlist(Watchlist w) {
		return repo.save(w);
	}
	public List<Watchlist> getAllMovies(){
		return repo.findAll();
	}
	public void deleteMovie(Long id) {
		repo.deleteById(id);
	}
	public Optional<Watchlist> movieById(Long id){
		return repo.findById(id);
	}
	public Watchlist getMovieById(Long id) {
		return repo.findById(id).get();
	}
}
