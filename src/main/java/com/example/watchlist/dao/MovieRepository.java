package com.example.watchlist.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.watchlist.model.Movies;

public interface MovieRepository extends JpaRepository<Movies,Long>{

}
