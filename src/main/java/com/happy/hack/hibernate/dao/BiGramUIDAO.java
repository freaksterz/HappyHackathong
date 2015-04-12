package com.happy.hack.hibernate.dao;

import com.happy.hack.hibernate.entity.AverageHotel;
import com.happy.hack.hibernate.entity.BiGram;
import com.happy.hack.hibernate.entity.BiGramUi;

import java.util.List;
import java.util.Map;

/**
 * Created by freakster on 11/4/15.
 */
public interface BiGramUIDAO {

    void addBigram( BiGramUi bi);
    List<BiGramUi> getAllData();

    List<Map<String, String>> getBiGramInteger(float value, float rooms, float locations, float cleanliness, float checkIn, float service, float businessService, String type) ;





}
