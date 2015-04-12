package com.happy.hack.nlp;

import com.happy.hack.hibernate.dao.AverageHotelDAOImpl;
import com.happy.hack.hibernate.dao.BiGramAverageDAOImpl;
import com.happy.hack.hibernate.dao.BudgetHotelDAOImpl;
import com.happy.hack.hibernate.entity.AverageHotel;
import com.happy.hack.hibernate.entity.BiGramAverage;
import com.happy.hack.hibernate.entity.BiGramBudget;
import com.happy.hack.hibernate.entity.BudgetHotel;

/**
 * Created by freakster on 12/4/15.
 */
public class BiGramBudgetNLP {

    public void biGramsConnection() {}

    public static void biGramEngine(BudgetHotel hotel) throws Exception {
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
                BiGramBudget biGramBudget=new BiGramBudget();
                biGramBudget.setContent(biGrams.toString());
                biGramBudget.setBusinessService(hotel.getBusinessService());
                biGramBudget.setChekIn(hotel.getChekIn());
                biGramBudget.setCleanliness(hotel.getCleanliness());
                biGramBudget.setLocations(hotel.getLocations());
                biGramBudget.setRooms(hotel.getRooms());
                biGramBudget.setService(hotel.getService());
//	biGramLuxury.setSleepQuality(hotel.getSleepQuality());
                biGramBudget.setValue(hotel.getValue());
                new BudgetHotelDAOImpl().addRow(biGramBudget);
                biGrams=new StringBuffer();
            }
        }

    }
    public static void main(String[] args) throws Exception {
        BudgetHotelDAOImpl DAO=new BudgetHotelDAOImpl();
//        DAO.getAllData();
        for (BudgetHotel lh : DAO.getAllData()) {
            biGramEngine(lh);
        }
    }
}
