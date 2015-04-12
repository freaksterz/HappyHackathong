package com.happy.hack.hibernate.dao;

import com.happy.hack.hibernate.entity.BiGramUi;
import com.happy.hack.hibernate.entity.BiGramUiluxury;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.happy.hack.hibernate.entity.BiGramUibudget;
import com.salesorderapp.common.util.HibernateUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BiGramUIBudgetDAOImpl implements BiGramUIBudgetDAO {

	@Override
	public void addRow(BiGramUibudget bl) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(bl);
        transaction.commit();
	}

    @Override
    public List<Map<String, String>> getBiGramInteger(float value, float rooms, float locations, float cleanliness, float checkIn, float service, float businessService) {

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from BiGramUiluxury where Value <= :value AND Rooms <= :rooms AND Locations <= :locations " +
                "AND Cleanliness <= :cleanliness AND ChekIn <= :checkin AND Service <= :service AND BusinessService <= :bussService " );

        query.setParameter("value", value);
        query.setParameter("rooms", rooms);
        query.setParameter("locations", locations);
        query.setParameter("cleanliness", cleanliness);
        query.setParameter("checkin", checkIn);
        query.setParameter("service", service);
        query.setParameter("bussService", businessService);
        //query.setParameter("sleepQty", sleepQuality);


        List<BiGramUiluxury> rowList = query.list();

        List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();

        for (int i = 0; i < rowList.size(); i++) {
            BiGramUiluxury biGramUi = (BiGramUiluxury)rowList.get(i);
            //if( (rawTable.getValue() <= value) && rawTable.getRooms() <= rooms && rawTable.getLocations() <= locations && (rawTable.getCleanliness() <=cleanliness) && (rawTable.getChekIn() <= checkIn) && (rawTable.getService() <= service) && (rawTable.getBusinessService() <= businessService) && (rawTable.getSleepQuality() <= sleepQuality)){
            Map<String, String> map = new HashMap<String,String>();
            map.put("text", biGramUi.getBiGram());
            map.put("weight", Float.toString(biGramUi.getCount()));
            mapList.add(map);

            //}

        }

        return mapList;

    }

}
