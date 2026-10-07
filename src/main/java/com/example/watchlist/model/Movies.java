package com.example.watchlist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Movies {
	@Id
	private Long id;
	private String mname;
	private String dname;
	private int year;
	
	public Movies() {
		super();
	}
	public Movies(Long id,String mname,String dname,int year) {
		super();
		this.id = id;
		this.mname = mname;
		this.dname = dname; 
		this.year = year;
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
