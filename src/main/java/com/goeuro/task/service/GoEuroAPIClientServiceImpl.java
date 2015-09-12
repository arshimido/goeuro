package com.goeuro.task.service;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpException;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.goeuro.task.config.Configuration;
import com.goeuro.task.model.City;
import com.goeuro.task.model.exception.APIResponseException;

public class GoEuroAPIClientServiceImpl implements GoEuroAPIClientService {

	@Override
	public List<City> getSuggestedCities(String cityName)
			throws APIResponseException {
		StringBuilder builder = new StringBuilder(Configuration.getInstance()
				.getAPIEndpointURL());
		builder.append(cityName);
		try {
			return unmarshal(doGet(builder.toString()));
		} catch (IOException e) {
			// log exception message and/or stack trace
			throw new APIResponseException(
					"Could not parse response. Details: " + e.getMessage());
		}
	}

	/**
	 * Send get request to specified URL, and returns response body as string.
	 * 
	 * @param URL
	 *            :
	 * @return String: containing the response body.
	 * @throws IOException
	 * @throws HttpException
	 */
	private String doGet(String URL) throws IOException, APIResponseException {
		try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
			HttpGet request = new HttpGet(URL);
			CloseableHttpResponse response = client.execute(request);
			StatusLine statusLine = response.getStatusLine();
			if (statusLine.getStatusCode() != HttpStatus.SC_OK) {
				throw new APIResponseException(
						"Could not retrieve data from API. response code: "
								+ statusLine.getStatusCode());
			}
			return EntityUtils.toString(response.getEntity(), "UTF-8");
		}
	}

	/**
	 * 
	 * @param jsonString
	 *            representing API response.
	 * @return List
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	private List<City> unmarshal(String jsonString) throws JsonParseException,
			JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(jsonString, mapper.getTypeFactory()
				.constructCollectionType(List.class, City.class));
	}
}
