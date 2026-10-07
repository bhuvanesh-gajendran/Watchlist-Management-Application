package com.example.watchlist.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.watchlist.model.Watchlist;

public interface WatchlistRepository extends JpaRepository<Watchlist,Long>{

}
