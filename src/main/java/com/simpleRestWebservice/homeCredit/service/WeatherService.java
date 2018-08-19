package com.simpleRestWebservice.homeCredit.service;

import java.util.List;

import com.simpleRestWebservice.homeCredit.domain.WeatherData;

public interface WeatherService {
	
	public List<WeatherData> retrieveWeatherData();

}
