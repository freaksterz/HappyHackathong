package com.happy.hack.hibernate.entity;

// Generated 12 Apr, 2015 4:15:49 AM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * BiGramUiaverage generated by hbm2java
 */
@Entity
@Table(name = "BiGramUIAverage", catalog = "Happyhack")
public class BiGramUiaverage implements java.io.Serializable {

	private String biGram;
	private float overall;
	private float value;
	private float rooms;
	private float locations;
	private float cleanliness;
	private float chekIn;
	private float service;
	private float businessService;
	private int sleepQuality;
	private float count;

	public BiGramUiaverage() {
	}

	public BiGramUiaverage(String biGram, float overall, float value,
			float rooms, float locations, float cleanliness, float chekIn,
			float service, float businessService, int sleepQuality, float count) {
		this.biGram = biGram;
		this.overall = overall;
		this.value = value;
		this.rooms = rooms;
		this.locations = locations;
		this.cleanliness = cleanliness;
		this.chekIn = chekIn;
		this.service = service;
		this.businessService = businessService;
		this.sleepQuality = sleepQuality;
		this.count = count;
	}

	@Id
	@Column(name = "BiGram", unique = true, nullable = false, length = 500)
	public String getBiGram() {
		return this.biGram;
	}

	public void setBiGram(String biGram) {
		this.biGram = biGram;
	}

	@Column(name = "Overall", nullable = false, precision = 12, scale = 0)
	public float getOverall() {
		return this.overall;
	}

	public void setOverall(float overall) {
		this.overall = overall;
	}

	@Column(name = "Value", nullable = false, precision = 12, scale = 0)
	public float getValue() {
		return this.value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	@Column(name = "Rooms", nullable = false, precision = 12, scale = 0)
	public float getRooms() {
		return this.rooms;
	}

	public void setRooms(float rooms) {
		this.rooms = rooms;
	}

	@Column(name = "Locations", nullable = false, precision = 12, scale = 0)
	public float getLocations() {
		return this.locations;
	}

	public void setLocations(float locations) {
		this.locations = locations;
	}

	@Column(name = "Cleanliness", nullable = false, precision = 12, scale = 0)
	public float getCleanliness() {
		return this.cleanliness;
	}

	public void setCleanliness(float cleanliness) {
		this.cleanliness = cleanliness;
	}

	@Column(name = "ChekIn", nullable = false, precision = 12, scale = 0)
	public float getChekIn() {
		return this.chekIn;
	}

	public void setChekIn(float chekIn) {
		this.chekIn = chekIn;
	}

	@Column(name = "Service", nullable = false, precision = 12, scale = 0)
	public float getService() {
		return this.service;
	}

	public void setService(float service) {
		this.service = service;
	}

	@Column(name = "BusinessService", nullable = false, precision = 12, scale = 0)
	public float getBusinessService() {
		return this.businessService;
	}

	public void setBusinessService(float businessService) {
		this.businessService = businessService;
	}

	@Column(name = "SleepQuality", nullable = false)
	public int getSleepQuality() {
		return this.sleepQuality;
	}

	public void setSleepQuality(int sleepQuality) {
		this.sleepQuality = sleepQuality;
	}

	@Column(name = "Count", nullable = false, precision = 12, scale = 0)
	public float getCount() {
		return this.count;
	}

	public void setCount(float count) {
		this.count = count;
	}

}