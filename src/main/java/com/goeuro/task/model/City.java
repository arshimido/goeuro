package com.goeuro.task.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class City {

	@JsonProperty(value = "_id")
	private Integer id;
	private String key;
	private String name;
	private String fullName;

	@JsonProperty(value = "iata_airport_code")
	private String iataAirportCode;
	private String type;
	private String country;

	@JsonProperty(value = "geo_position")
	private GeoPosition geoPosition;

	private Integer locationId;
	private Boolean inEurope;
	private String countryCode;
	private Boolean coreCountry;
	private Double distance;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIataAirportCode() {
		return iataAirportCode;
	}

	public void setIataAirportCode(String iataAirportCode) {
		this.iataAirportCode = iataAirportCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public Boolean getInEurope() {
		return inEurope;
	}

	public void setInEurope(Boolean inEurope) {
		this.inEurope = inEurope;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Boolean getCoreCountry() {
		return coreCountry;
	}

	public void setCoreCountry(Boolean coreCountry) {
		this.coreCountry = coreCountry;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public GeoPosition getGeoPosition() {
		return geoPosition;
	}

	public void setGeoPosition(GeoPosition geoPosition) {
		this.geoPosition = geoPosition;
	}
}
