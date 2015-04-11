package com.happy.hack.hibernate.entity;

public class HotelData {

	private String name;
	private String hotelId;
	private String hotelUrl;
	private String imgUrl;
	private double avgPrice;
	
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelUrl() {
		return hotelUrl;
	}
	public void setHotelUrl(String hotelUrl) {
		this.hotelUrl = hotelUrl;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public double getAvgPrice() {
		return avgPrice;
	}
	public void setAvgPrice(double avgPrice) {
		this.avgPrice = avgPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
