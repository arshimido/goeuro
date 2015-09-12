package com.goeuro.task.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import au.com.bytecode.opencsv.CSVWriter;

import com.goeuro.task.config.Configuration;
import com.goeuro.task.model.City;

public class FileServiceImpl implements FileService {

	@Override
	public void writeToCSV(List<City> cities) throws IOException {
		deleteFileIfExists(Configuration.getInstance().getCSVFilePath());
		CSVWriter writer = new CSVWriter(new FileWriter(Configuration
				.getInstance().getCSVFilePath()), ',');
		String[] fileHeaders = { "_id", "name", "type", "latitude", "longitude" };
		writer.writeNext(fileHeaders);
		for (City city : cities) {
			String[] record = { city.getId().toString(), city.getName(),
					city.getType(),
					city.getGeoPosition().getLatitude().toString(),
					city.getGeoPosition().getLongitude().toString() };
			writer.writeNext(record);
		}
		writer.close();
	}

	/**
	 * Deletes a file if it already exists in the specified path.
	 * 
	 * @param filePath
	 */
	private void deleteFileIfExists(String filePath) {
		File file = new File(filePath);
		if (file.exists()) {
			file.delete();
		}
	}

}
