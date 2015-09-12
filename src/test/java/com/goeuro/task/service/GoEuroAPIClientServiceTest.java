package com.goeuro.task.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.goeuro.task.model.City;
import com.goeuro.task.model.exception.APIResponseException;

public class GoEuroAPIClientServiceTest {

	@Test
	public void consumeAPI() throws APIResponseException {
		GoEuroAPIClientService service = new GoEuroAPIClientServiceImpl();
		List<City> cityList = service.getSuggestedCities("cairo");
		Assert.assertTrue(cityList != null);
	}
}
