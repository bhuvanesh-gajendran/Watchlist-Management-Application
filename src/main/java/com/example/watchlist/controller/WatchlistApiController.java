package com.example.watchlist.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.watchlist.model.Movies;
import com.example.watchlist.model.Watchlist;
import com.example.watchlist.service.MoviesService;
import com.example.watchlist.service.WatchlistService;

@RestController
@RequestMapping("/api")
public class WatchlistApiController {
	@Autowired
	private WatchlistService sero;
	@Autowired
	private MoviesService msero;
	
	@GetMapping("/watchlist")
	public List<Watchlist> getAllWatchlist() {
		return sero.getAllMovies();
	}
	@PostMapping("/watchlist")
	public ResponseEntity<Watchlist> createWatchlist(@RequestBody Watchlist w){
		Watchlist w1 = sero.saveWatchlist(w);
		return ResponseEntity.status(HttpStatus.CREATED).body(w1);
	}
	@GetMapping("/watchlist/{id}")
	public ResponseEntity<Watchlist> getWatchlistById(@PathVariable Long id){
		Optional<Watchlist> w1 = sero.movieById(id);
		return w1.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
	}	
	@DeleteMapping("/watchlist/{id}")
	public ResponseEntity<Void> deleteWatchlist(@PathVariable Long id){
		if(!sero.movieById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		sero.deleteMovie(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping("/watchlist/{id}")
	public ResponseEntity<Watchlist> UpdateWatchlistById(@PathVariable Long id,@RequestBody Watchlist w){
		if(!sero.movieById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		w.setId(id);
		Watchlist w1 = sero.saveWatchlist(w);
		return ResponseEntity.ok(w1);
	}
	@GetMapping("/movies")
	public List<Movies> getAllMovies(){
		return msero.getAll();
	}
	@PostMapping("/movies")
	public ResponseEntity<Movies> createMovies(@RequestBody Movies m){
		Movies m1 = msero.saveMovie1(m);
		return ResponseEntity.status(HttpStatus.CREATED).body(m1);
	}
	@GetMapping("/movies/{id}")
	public ResponseEntity<Movies> getMoviesById(@PathVariable Long id){
		Optional<Movies> m1 = msero.getThrough(id);
		return m1.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
	}
	@DeleteMapping("/movies/{id}")
	public ResponseEntity<Void> deleteMovies(@PathVariable Long id){
		if(!msero.getThrough(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		msero.DeleteMovie(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping("/movies/{id}")
	public ResponseEntity<Movies> updateMoviesById(@PathVariable Long id,@RequestBody Movies m){
		if(!msero.getThrough(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		m.setId(id);
		Movies m1 = msero.saveMovie1(m);
		return ResponseEntity.ok(m1);
	}
}