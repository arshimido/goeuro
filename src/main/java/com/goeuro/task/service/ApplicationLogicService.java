package com.goeuro.task.service;

import com.goeuro.task.model.exception.APIResponseException;
import com.goeuro.task.model.exception.FileGenerationException;

public interface ApplicationLogicService {

	/**
	 * This method queries GoEuro APIs and
	 * 
	 * @param cityName
	 * 
	 * @throws APIResponseException
	 *             if it couldn't call and/or parse the response.
	 * @throws FileGenerationException
	 *             if couldn't write to file.
	 */
	void queryAndGenerateCSV(String cityName) throws APIResponseException,
			FileGenerationException;

}
