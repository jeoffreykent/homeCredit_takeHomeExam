package com.simpleRestWebservice.homeCredit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simpleRestWebservice.homeCredit.domain.WeatherData;
import com.simpleRestWebservice.homeCredit.service.WeatherService;

@RestController
public class WeatherController {
	
	@Autowired
	private WeatherService weatherService;
	
	@RequestMapping("/retrieveWeatherData")
	public List<WeatherData> retrieveWeather(@RequestParam(value="name", defaultValue="World") String name) {
		
		List<WeatherData> weatherDataList = new ArrayList<WeatherData>();
		try {
			
			//testing push from git
			
			
			weatherDataList = weatherService.retrieveWeatherData();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return weatherDataList;
	}

}
