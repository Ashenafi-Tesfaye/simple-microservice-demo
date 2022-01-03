package com.ashu.weatherdatademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ashu.weatherdatademo.service.WeatherService;


public class WeatherController {
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("/")
	public String home(Model model) {
				
		model.addAttribute("lastestWeatherData", weatherService.getWeatherData());
			
		return "home";
	}

    
}
