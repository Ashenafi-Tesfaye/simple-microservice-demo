package com.covidtracker.ag.covidtracker.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.covidtracker.ag.covidtracker.demo.model.CovidStatus;
import com.covidtracker.ag.covidtracker.demo.services.Covid19DataService;

@Controller
public class HomeController {
	
	@Autowired
	private Covid19DataService covid19DataService;
	
	@GetMapping("/")
	public String home(Model model) {
		
		List<CovidStatus> sumofAllcases = covid19DataService.getCovidData();
		int globalData = sumofAllcases.stream().mapToInt(stat ->stat.getTotalCases()).sum();
		
		model.addAttribute("lastestCovidData", covid19DataService.getCovidData());
		model.addAttribute("sumofAllcases", globalData);
		
		
		
		return "home";
	}

    

}
