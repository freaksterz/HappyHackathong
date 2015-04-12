/**
 * 
 */
package com.happy.hack.nlp;

import com.happy.hack.hibernate.dao.*;
import com.happy.hack.hibernate.entity.*;


/**
 * @author saurabhshashank
 * <p>A Simple consecutive words bi-gram alogrithm</p>
 *
 */

import com.happy.hack.hibernate.dao.LuxuryHotelDAOImpl;
import com.happy.hack.hibernate.entity.LuxuryHotel;


/**
 * @author saurabhshashank
 * <p>A Simple consecutive words bi-gram alogrithm</p>
 *
 */
public class BiGramsAverage {
    public void biGramsConnection() {}

    public static void biGramEngine(AverageHotel hotel) throws Exception {
// the line are sep by ||
        String content=StopWordRemoval.getStopWordRemoval(hotel.getContent());
        StringBuffer biGrams = new StringBuffer();
        String[] lines = content.split("\\|\\|");
        for (String line : lines) {
            String[] words = line.trim().split(" ");
            for (int i = 0; i < words.length; i++) {
                if (i == words.length - 1) {
                    continue;
                }
                biGrams.append(words[i] + "-" + words[i + 1] + " ");
//	Persist the data in the tables bi-gram,value,....
                BiGramAverage biGramAverage=new BiGramAverage();
                biGramAverage.setContent(biGrams.toString());
                biGramAverage.setBusinessService(hotel.getBusinessService());
                biGramAverage.setChekIn(hotel.getChekIn());
                biGramAverage.setCleanliness(hotel.getCleanliness());
                biGramAverage.setLocations(hotel.getLocations());
                biGramAverage.setRooms(hotel.getRooms());
                biGramAverage.setService(hotel.getService());
//	biGramLuxury.setSleepQuality(hotel.getSleepQuality());
                biGramAverage.setValue(hotel.getValue());
                new BiGramAverageDAOImpl().addRow(biGramAverage);
//                new BiGramLuxuryDAOImpl().addRow(biGramAverage);
//                System.out.println(biGrams);
                biGrams=new StringBuffer();
            }
        }

    }
    public static void main(String[] args) throws Exception {
        AverageHotelDAOImpl DAO=new AverageHotelDAOImpl();
//        DAO.getAllData();
        for (AverageHotel lh : DAO.getAllData()) {
            biGramEngine(lh);
        }
    }
}
