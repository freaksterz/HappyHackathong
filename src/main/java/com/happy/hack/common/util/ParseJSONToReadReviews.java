package com.happy.hack.common.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.happy.hack.hibernate.entity.RawTable;

public class ParseJSONToReadReviews {
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		File folder = new File("E:/gainsight/json");
		File file[]=folder.listFiles();
		
		JSONParser parser = new JSONParser();
		for (File file2 : file) {
			System.out.println(file2.getAbsolutePath());
			Object obj = parser.parse(new FileReader(file2.getAbsolutePath()));
			JSONObject jsonObject = (JSONObject)obj;
						
			/* read review array and hotel info object */
			
			JSONObject hotelInfo = (JSONObject) jsonObject.get("HotelInfo");
			JSONArray reviewsArray = (JSONArray) jsonObject.get("Reviews");
			
			
			RawTable rawTable = new RawTable();
			
			hotelInfo.get("Name");
			hotelInfo.get("HotelURL");
			hotelInfo.get("Address");
			hotelInfo.get("HotelID");
			hotelInfo.get("ImgURL");
			
			String price = (String) hotelInfo.get("Price");
			
			String[] val = price.split("-");
			int val1 = Integer.parseInt(val[0].trim().replaceAll("[^0-9]", ""));
			int val2 = Integer.parseInt(val[1].trim().replaceAll("[^0-9]", ""));
			
			float avg = (val1 + val2) / 2;
			
			
			
			
			
			for( int i = 0; i < reviewsArray.size(); i++ ) {
				
				JSONObject review = (JSONObject) reviewsArray.get(i);
				
				
				review.get("AuthorLocation");
				review.get("Author");
				review.get("Content");
				review.get("Date");
				review.get("Title");
				review.get("ReviewID");
				
				
				JSONObject ratings = (JSONObject) review.get("Ratings");
				
				
				if ( null != ratings.get("Cleanliness") )
					ratings.get("Cleanliness");
				
				if ( null != ratings.get("Location") )
					ratings.get("Location");
				
				if ( null != ratings.get("Overall") )
					ratings.get("Overall");
				
				if ( null != ratings.get("Rooms") )
					ratings.get("Rooms");
				
				if ( null != ratings.get("Service") )
					ratings.get("Service");
				
				if ( null != ratings.get("Sleep Quality") )
					ratings.get("Sleep Quality");
				
				if ( null != ratings.get("Value") ){
										
				}
				
			}
			
			
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
