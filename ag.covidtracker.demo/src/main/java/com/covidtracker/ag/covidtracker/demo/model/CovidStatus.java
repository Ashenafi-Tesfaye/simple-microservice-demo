package com.covidtracker.ag.covidtracker.demo.model;


public class CovidStatus {
	
	//@Column(name="Province/State");
	private  String state; 
	
	//@Column(name="Country/Region")
	private String country; 
	
	//@Column(name="Lat")
	private String lat; 
	
	//@Column(name="Long")
	private String lng;
	
	private int totalCases;

	public CovidStatus() {
		super();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public int getTotalCases() {
		return totalCases;
	}

	public void setTotalCases(int totalCases) {
		this.totalCases = totalCases;
	}

	@Override
	public String toString() {
		return "CovidStatus [state=" + state + ", country=" + country + ", lat=" + lat + ", lng=" + lng
				+ ", totalCases=" + totalCases + "]";
	}

	
	
}
