package com.covid_analysis.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "coviddata")
public class CovidData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String date;
	private String state;
	private String district;
	private String tested;
	private String confirmed;
	private String rocovered;
	

}
