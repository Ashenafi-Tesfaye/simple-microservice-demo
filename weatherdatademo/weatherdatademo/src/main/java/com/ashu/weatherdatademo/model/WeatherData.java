package com.ashu.weatherdatademo.model;

public class WeatherData {
	
	private String country; 
	
	private String city; 
	
	private String temp_min;
	
	private String temp_max;
    
    private String lat; 
	
	private String lon;
	
	private String temp;
	
	private String feels_like;

	public WeatherData() {
		
	}

	
	public WeatherData(String country, String city, String temp_min, String temp_max, String lat, String lon,
			String temp, String feels_like) {
		super();
		this.country = country;
		this.city = city;
		this.temp_min = temp_min;
		this.temp_max = temp_max;
		this.lat = lat;
		this.lon = lon;
		this.temp = temp;
		this.feels_like = feels_like;
	}


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTemp_min() {
		return temp_min;
	}

	public void setTemp_min(String temp_min) {
		this.temp_min = temp_min;
	}

	public String getTemp_max() {
		return temp_max;
	}

	public void setTemp_max(String temp_max) {
		this.temp_max = temp_max;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getFeels_like() {
		return feels_like;
	}

	public void setFeels_like(String feels_like) {
		this.feels_like = feels_like;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	@Override
	public String toString() {
		return "WeatherData [country=" + country + ", city=" + city + ", temp_min=" + temp_min + ", temp_max="
				+ temp_max + ", lat=" + lat + ", lon=" + lon + ", temp=" + temp + ", feels_like=" + feels_like + "]";
	}

	
	
}
