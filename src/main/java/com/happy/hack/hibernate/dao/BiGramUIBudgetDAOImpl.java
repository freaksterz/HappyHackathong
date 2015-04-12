package com.happy.hack.hibernate.dao;

import com.happy.hack.common.util.JDBCConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.happy.hack.hibernate.entity.BiGramUibudget;
import com.salesorderapp.common.util.HibernateUtil;

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
    public List<Map<String, String>> getBiGramInteger(float value, float rooms, float locations, float cleanliness, float checkIn, float service, float businessService, String type) {


        return JDBCConnection.getLuxury(value, rooms, locations, cleanliness, checkIn, service, businessService, type);

        /*Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from BiGramUiluxury where Value <= :value AND Rooms <= :rooms AND Locations <= :locations " +
                "AND Cleanliness <= :cleanliness AND ChekIn <= :checkin AND Service <= :service AND BusinessService <= :bussService ORDER BY Count" );

        query.setParameter("value", value);
        query.setParameter("rooms", rooms);
        query.setParameter("locations", locations);
        query.setParameter("cleanliness", cleanliness);
        query.setParameter("checkin", checkIn);
        query.setParameter("service", service);
        query.setParameter("bussService", businessService);
        //query.setParameter("sleepQty", sleepQuality);


      List<BiGramUiluxury> rowList = query.list();

        //Criteria criteria = session.createCriteria(BiGramUiluxury.class).setProjection(Projections.projectionList()).add(Projections.property("value"),"value").add(Projections.property("rooms"),"rooms")

        *//*ProjectionList projList = Projections.projectionList();
        projList.add(Projections.groupProperty("par"), "parAlias");
        projList.add(Projections.rowCount(), "countAlias");
        criteria.setProjection(projList);

        criteria.setResultTransformer(Transformers.aliasToBean(ObjDto.class));*//*

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

        return mapList;*/

    }

}
