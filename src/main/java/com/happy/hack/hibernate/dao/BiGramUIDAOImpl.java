package com.happy.hack.hibernate.dao;

import com.happy.hack.hibernate.entity.BiGram;
import com.happy.hack.hibernate.entity.BiGramUi;
import com.happy.hack.hibernate.entity.RawTable;
import com.salesorderapp.common.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Map;

/**
 * Created by freakster on 12/4/15.
 */
public class BiGramUIDAOImpl implements BiGramUIDAO {
    @Override
    public void addBigram(BiGramUi bi) {

    }

    @Override
    public List<BiGramUi> getAllData() {
        return null;
    }

    @Override
    public List<Map<BiGram, Integer>> getBiGramInteger(float value, float rooms, float locations, float cleanliness, float checkIn, float service, float businessService, int sleepQuality) {

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from BiGram B where B");
        List<RawTable> rowList = query.list();







        return null;
    }
}
