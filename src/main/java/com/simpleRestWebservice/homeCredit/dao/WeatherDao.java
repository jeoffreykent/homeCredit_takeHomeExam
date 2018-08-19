package com.simpleRestWebservice.homeCredit.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.simpleRestWebservice.homeCredit.domain.WeatherData;


@Mapper
public interface WeatherDao {
	
	@Insert("INSERT INTO public.\"WeatherLog\"(\r\n" + 
			"	\"responseId\", location, \"actualWeather\", temperature, \"dtimeInserted\")\r\n" + 
			"	VALUES (#{Id}, #{location}, #{weather}, #{temperature}, NOW());")
	public void insertWeatherData(WeatherData weather);

}
