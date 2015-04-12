package com.happy.hack.common.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.happy.hack.hibernate.dao.RawTableDAOImpl;
import com.happy.hack.hibernate.entity.HotelData;
import com.happy.hack.hibernate.entity.RawTable;

public class ParseJSONToReadReviews {
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		File folder = new File("/home/freakster/Documents/gain/json_format/json");
		File file[]=folder.listFiles();
		long counter = 0;
		JSONParser parser = new JSONParser();
		for (File file2 : file) {
			System.out.println(file2.getAbsolutePath());
			Object obj = parser.parse(new FileReader(file2.getAbsolutePath()));
			JSONObject jsonObject = (JSONObject)obj;

			/* read review array and hotel info object */
			
			JSONObject hotelInfo = (JSONObject) jsonObject.get("HotelInfo");
			JSONArray reviewsArray = (JSONArray) jsonObject.get("Reviews");
			
			
			HotelData hotelData = new HotelData();
						
			hotelData.setHotelId(hotelInfo.get("HotelID").toString());
			//hotelData.setHotelUrl(hotelInfo.get("HotelURL").toString());
			//hotelData.setImgUrl(hotelInfo.get("ImgURL").toString());

            if ( null != hotelInfo.get("Name") )
			    hotelData.setName(hotelInfo.get("Name").toString());
			
			String price = (String) hotelInfo.get("Price");
            System.out.println("price "+price);
            String[] val = price.split("-");

            if ( price.contains("-") ) {
                int val1 = Integer.parseInt(val[0].trim().replaceAll("[^0-9]", ""));
                int val2 = Integer.parseInt(val[1].trim().replaceAll("[^0-9]", ""));

                float avg = (val1 + val2) / 2;

                hotelData.setAvgPrice((double) avg);

            } else if ( null != price && !price.isEmpty() && price.trim().length()!=0 ) {
                try{
                    hotelData.setAvgPrice( Double.parseDouble(price.replaceAll("[^0-9]", "")));
                } catch( NumberFormatException e ){

                }

            }

			
			for( int i = 0; i < reviewsArray.size(); i++ ) {
				
				JSONObject review = (JSONObject) reviewsArray.get(i);
                counter++;
				RawTable rawTable = new RawTable();
				
				/*set hotel data */
				rawTable.setHotelId(hotelData.getHotelId());
				rawTable.setUrl(hotelData.getHotelUrl());
				rawTable.setImgSrc(hotelData.getImgUrl());
				rawTable.setAvgPrice(hotelData.getAvgPrice());
				rawTable.setName(hotelData.getName());
				
				rawTable.setAuthor(review.get("Author").toString());
				rawTable.setContent(review.get("Content").toString());
				rawTable.setDate(review.get("Date").toString());
				
				
				JSONObject ratings = (JSONObject) review.get("Ratings");
				
				
				if ( null != ratings.get("Cleanliness") ) {
					rawTable.setCleanliness(Float.parseFloat(ratings.get("Cleanliness").toString()));
				}
				
				if ( null != ratings.get("Location") ){
					rawTable.setLocations(Float.parseFloat(ratings.get("Location").toString()));
				}
				
				if ( null != ratings.get("Overall") ){
					rawTable.setOverallRating(Float.parseFloat(ratings.get("Overall").toString()));
				}
				
				if ( null != ratings.get("Rooms") ){
					rawTable.setRooms(Float.parseFloat(ratings.get("Rooms").toString()));
				}
				
				if ( null != ratings.get("Service") ){
					rawTable.setService(Float.parseFloat(ratings.get("Service").toString()));
				}
				
				/*if ( null != ratings.get("Sleep Quality") ){
					rawTable.setSleepQuality(Float.parseFloat(ratings.get("Sleep Quality").toString()));
				}*/
				
				if ( null != ratings.get("Value") ){
					rawTable.setValue(Float.parseFloat(ratings.get("Value").toString()));
				}
				
				
				RawTableDAOImpl rawTableDao = new RawTableDAOImpl();
				rawTableDao.addRow(rawTable);
				
			}


            System.out.println("counter = " + counter);

        }
	}
	
	
	
	public void parseJSONToGetReviews() {
		
		JSONParser parser = new JSONParser();
		
		try {
			
			File folder = new File("E:/gainsight/json");
			File file[]=folder.listFiles();
			for (File file2 : file) {
				System.out.println(file2.getName());
			}
			
			Object obj = parser.parse(new FileReader("c:\\test.json"));
			JSONObject jsonObject = (JSONObject)obj;
			
			
			/* read review array and hotel info object */
			
			JSONObject hotelInfo = (JSONObject) jsonObject.get("HotelInfo");
			JSONArray reviewsArray = (JSONArray) jsonObject.get("Reviews");
			
			
			
			
			
			
		} catch ( Exception e ) {
			System.out.println("Error reading file ");
			e.printStackTrace();
		}
		
	}

}
