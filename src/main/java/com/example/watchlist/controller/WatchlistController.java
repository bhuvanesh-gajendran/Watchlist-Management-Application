package com.example.watchlist.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.watchlist.model.Movies;
import com.example.watchlist.model.Watchlist;
import com.example.watchlist.service.MoviesService;
import com.example.watchlist.service.WatchlistService;

@Controller
public class WatchlistController {
	@Autowired
	private WatchlistService sero;
	
	@Autowired
	private MoviesService msero;
	
	@GetMapping("/home")
	public String getHome() {
		return "home";
	}
	@GetMapping("/add")
	public String getAdd(Model model) {
		model.addAttribute("watchlist",new Watchlist());
		return "add";
	}
	@PostMapping("/add")
	public String addMovie(@ModelAttribute Watchlist w) {
			sero.saveMovie(w);
			return "redirect:/all";
	}
	@GetMapping("/all")
	public String getAll(Model model) {
		model.addAttribute("watchlist",sero.getAllMovies());
		return "all";
	}
	@GetMapping("/all/update/{id}")
	public String UpdateMovies(@PathVariable Long id,Model model) {
		Optional<Watchlist> elementinlist = sero.movieById(id);
		if(elementinlist.isPresent()) {
			model.addAttribute("watchlist",elementinlist.get());
			msero.DeleteMovie(id);	
			return "add";			
		}
		return "redirect:/all";
	}
	@GetMapping("/all/delete/{id}")
	public String DeleteMovies(@PathVariable Long id) {
		sero.deleteMovie(id);
		msero.DeleteMovie(id);
		return "redirect:/all";
	}
	@GetMapping("/mine")
	public String getMine(Model model) {
		model.addAttribute("movies",msero.getAll());
		return "mine";
	}
	@GetMapping("/mine/add/{id}")
	public String sendMovietoList(@PathVariable Long id) {
		Watchlist w = sero.getMovieById(id);
		Movies m1 = new Movies(w.getId(),w.getMname(),w.getDname(),w.getYear());
		msero.saveMovie(m1);
		return "redirect:/mine";
	}
	@GetMapping("/mine/delete/{id}")
	public String deleteMovie(@PathVariable Long id) {
		msero.DeleteMovie(id);
		return "redirect:/mine";
	}
}
