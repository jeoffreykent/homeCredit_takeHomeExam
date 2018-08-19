package com.simpleRestWebservice.homeCredit.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simpleRestWebservice.homeCredit.dao.WeatherDao;
import com.simpleRestWebservice.homeCredit.domain.WeatherData;

import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;

@Component
public class WeatherServiceImpl implements WeatherService{
	
	@Autowired
	private WeatherDao weatherDao;
	
	@Override
	public List<WeatherData> retrieveWeatherData() {
		List<WeatherData> weatherDataList = new ArrayList<WeatherData>();
		boolean isMetric = true;
		String owmApiKey = "74553e8cd116c9557337c329a316c56b";
		long[] cityCode = new long[] {2643743, 3067696, 5391959};
		
		
		OpenWeatherMap.Units units = (isMetric)
		        ? OpenWeatherMap.Units.METRIC
		        : OpenWeatherMap.Units.IMPERIAL;
		
		OpenWeatherMap owm = new OpenWeatherMap(units, owmApiKey);
		        
		 try {
			 for(int i = 0; i < cityCode.length; i++) {
				 WeatherData weather = new WeatherData();
				 CurrentWeather currentWeather = owm.currentWeatherByCityCode(cityCode[i]);
				 
				 weather.setId(currentWeather.getSysInstance().getId());
				 weather.setLocation(currentWeather.getCityName());
				 weather.setTemperature(currentWeather.getMainInstance().getTemperature());
				 weather.setWeather(currentWeather.getWeatherInstance(0).getWeatherName());
				 
				 weatherDataList.add(weather);
				 
				 this.insertWeatherData(weather);
				 
			 }
			 
		 }catch (JSONException e) {
		      e.printStackTrace();
		 }
		 
		 return weatherDataList;
		
	}
	
	public void insertWeatherData(WeatherData weather) {
		weatherDao.insertWeatherData(weather);
	}
	

}
