package com.goeuro.task.service;

import java.io.IOException;
import java.util.List;

import com.goeuro.task.model.City;

public interface FileService {

	/**
	 * writes list of cities to CSV file in the following format: _id, name,
	 * type, latitude, longitude
	 * 
	 * @param cities
	 *            : List of cities to write.
	 * @throws IOException
	 */
	void writeToCSV(List<City> cities) throws IOException;
}
