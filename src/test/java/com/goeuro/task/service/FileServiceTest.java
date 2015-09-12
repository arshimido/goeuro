package com.goeuro.task.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import au.com.bytecode.opencsv.CSVReader;

import com.goeuro.task.config.Configuration;
import com.goeuro.task.model.City;
import com.goeuro.task.model.GeoPosition;

public class FileServiceTest {

	private FileService service = new FileServiceImpl();
	private List<City> cityList;
	
	@Before
	public void prepareData() {
		cityList = new ArrayList<City>();

		City c = new City();
		c.setId(15223);
		c.setName("name 1");
		c.setType("type 1");
		c.setGeoPosition(new GeoPosition(13.28903, 52.5548));
		cityList.add(c);

		c = new City();
		c.setId(7785);
		c.setName("Name 2");
		c.setType("type 2");
		c.setGeoPosition(new GeoPosition(10.04366, 45.50298));
		cityList.add(c);

		c = new City();
		c.setId(82992);
		c.setName("name 3");
		c.setType("type 3");
		c.setGeoPosition(new GeoPosition(13.41053, 52.52437));
		cityList.add(c);
	}

	@Test
	public void createCSVFile() throws IOException {
		try {
			service.writeToCSV(cityList);
		} catch (IOException e) {
			Assert.fail();
		}

		CSVReader reader = new CSVReader(new FileReader(Configuration.getInstance().getCSVFilePath()));
		List<String[]> list = reader.readAll();
		reader.close();
		Assert.assertNotNull(list);
		Assert.assertNotEquals(new ArrayList<String[]>(), list);
		
		// because of headers record
		Assert.assertEquals(cityList.size() + 1, list.size());
	}

	@Test
	public void createEmptyCSV() throws IOException {
		try {
			service.writeToCSV(new ArrayList<City>());
		} catch (IOException e) {
			Assert.fail();
		}

		CSVReader reader = new CSVReader(new FileReader("./output.csv"));
		List<String[]> list = reader.readAll();
		reader.close();
		Assert.assertNotNull(list);
		Assert.assertNotEquals(new ArrayList<String[]>(), list);

		// the headers record only
		Assert.assertEquals(1, list.size());		
	}
}
