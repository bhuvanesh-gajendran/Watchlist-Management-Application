package com.example.watchlist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Watchlist {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String mname;
	private String dname;
	private int year;
	
	public Watchlist() {
		super();
	}
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id=id;
	}
    public String getMname() {
        return this.mname;
    }
    public void setMname(String mname) {
        this.mname = mname;
    }
    public String getDname() {
        return this.dname;
    }
    public void setDname(String dname) {
        this.dname = dname;
    }
    public int getYear() {
        return this.year;
    }
    public void setYear(int year) {
        this.year = year;
    }
}
