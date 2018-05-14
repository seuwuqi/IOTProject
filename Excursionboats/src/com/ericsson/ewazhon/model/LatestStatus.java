package com.ericsson.ewazhon.model;

public class LatestStatus {

	private int idboats;
	private float longitude;
	private float latitude;
	private float altitude;
	private String event;


	public LatestStatus(int idboats, float longitude, float latitude, float altitude, String event) {
		super();
		this.idboats = idboats;
		this.longitude = longitude;
		this.latitude = latitude;
		this.altitude = altitude;
		this.event = event;
	}

	public int getIdboats() {
		return idboats;
	}

	public void setIdboats(int idboats) {
		this.idboats = idboats;
	}

	public float getlongitude() {
		return longitude;
	}

	public void setlongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getAltitude() {
		return altitude;
	}

	public void setAltitude(float altitude) {
		this.altitude = altitude;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "LatestStatus [idboats=" + idboats + ", longitude=" + longitude + ", latitude=" + latitude
				+ ", altitude=" + altitude + ", event=" + event + "]";
	}
	
}
