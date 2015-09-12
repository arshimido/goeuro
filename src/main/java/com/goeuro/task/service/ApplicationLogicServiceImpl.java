package com.goeuro.task.service;

import java.util.List;

import com.goeuro.task.model.City;
import com.goeuro.task.model.exception.APIResponseException;
import com.goeuro.task.model.exception.FileGenerationException;

public class ApplicationLogicServiceImpl implements ApplicationLogicService {

	// Those services can be injected through DI(Dependency Injection) container
	// like "spring".
	private GoEuroAPIClientService goEuroSerive = new GoEuroAPIClientServiceImpl();
	private FileService fileService = new FileServiceImpl();

	@Override
	public void queryAndGenerateCSV(String cityName)
			throws APIResponseException, FileGenerationException {
		try {
			List<City> cities = goEuroSerive.getSuggestedCities(cityName);
			fileService.writeToCSV(cities);
		} catch (Exception e) {
			// log exception message and/or stack trace
			throw new FileGenerationException("Could not write to file.");
		}
	}

}
