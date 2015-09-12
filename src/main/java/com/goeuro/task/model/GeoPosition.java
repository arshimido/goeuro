package com.goeuro.task.model;

public class GeoPosition {

	private Double latitude;
	private Double longitude;

	public GeoPosition() {
	}

	public GeoPosition(Double longitude, Double latitude) {
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

}
