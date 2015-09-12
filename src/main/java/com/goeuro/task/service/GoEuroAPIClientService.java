package com.goeuro.task.service;

import java.util.List;

import com.goeuro.task.model.City;
import com.goeuro.task.model.exception.APIResponseException;

public interface GoEuroAPIClientService {

	/**
	 * call GoEuro API and return list of cities
	 * 
	 * @param cityName
	 *            : String for city name to query about
	 * @return List of {@link City}
	 */
	List<City> getSuggestedCities(String cityName) throws APIResponseException;
}
