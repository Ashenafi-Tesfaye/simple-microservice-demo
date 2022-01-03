package com.ashu.weatherdatademo.service;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ashu.weatherdatademo.model.WeatherData;

@Service
public class WeatherService {
	public static String DATA_URL = "http://api.openweathermap.org/data/2.5/weather?q=Addis Ababa&units=Metric&APIkey=056c44cf01f7bb1056aa6a70e028a900";

	private List<WeatherData> weatherData = new ArrayList<>();
	
	
	public List<WeatherData> getWeatherData() {
		return weatherData;
	}

	public void setWeatherData(List<WeatherData> weatherData) {
		this.weatherData = weatherData;
	}

	@PostConstruct
	@Scheduled(cron = "* * * 1 * *")
	public void fetchWeatherData() throws IOException, InterruptedException {
		
		List<WeatherData> updatedWetherData = new ArrayList<>();
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(DATA_URL)).build();

		HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

		StringReader csvReader = new StringReader(httpResponse.body());

		
		  Iterable<CSVRecord> data =
		  CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvReader); 
		  
		  for (CSVRecord datum : data) { 
			  
			  WeatherData weatherData = new WeatherData();
			  weatherData.setCountry(datum.get("sys.country"));
			  weatherData.setCity(datum.get("name"));
			  weatherData.setCountry(datum.get("main.temp_max"));
			  weatherData.setCity(datum.get("main.temp_min"));
			  weatherData.setCountry(datum.get("coord.lat"));
			  weatherData.setCity(datum.get("coord.lon"));
			  weatherData.setCountry(datum.get("main.temp"));
			  weatherData.setCity(datum.get("main.feels_like"));
			 
			  updatedWetherData.add(weatherData);
		  }
		 
		  this.weatherData = updatedWetherData;
	}
}
