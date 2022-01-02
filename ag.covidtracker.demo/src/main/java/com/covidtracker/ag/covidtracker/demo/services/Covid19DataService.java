package com.covidtracker.ag.covidtracker.demo.services;

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

import com.covidtracker.ag.covidtracker.demo.model.CovidStatus;

@Service
public class Covid19DataService {

	public static String DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

	private List<CovidStatus> covidData = new ArrayList<>();
	
	
	public List<CovidStatus> getCovidData() {
		return covidData;
	}


	public void setCovidData(List<CovidStatus> covidData) {
		this.covidData = covidData;
	}


	@PostConstruct
	@Scheduled(cron = "* * * 1 * *")
	public void fetchCovidData() throws IOException, InterruptedException {
		
		List<CovidStatus> updatedData = new ArrayList<>();
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(DATA_URL)).build();

		HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

		StringReader csvReader = new StringReader(httpResponse.body());

		
		  Iterable<CSVRecord> data =
		  CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvReader); 
		  
		  for (CSVRecord datum : data) { 
			  
			 CovidStatus covid19Data = new CovidStatus();
			 covid19Data.setState(datum.get("Province/State"));
			 covid19Data.setCountry(datum.get("Country/Region")); 
			 covid19Data.setLat(datum.get("Lat")); 
			 covid19Data.setLng(datum.get("Long"));
			 
			 covid19Data.setTotalCases(Integer.parseInt(datum.get(datum.size()-1)));
		
			 updatedData.add(covid19Data);
		  }
		 
		  this.covidData = updatedData;
	}
}
