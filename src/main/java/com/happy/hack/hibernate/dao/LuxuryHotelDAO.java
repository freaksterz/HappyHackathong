package com.happy.hack.hibernate.dao;

import com.happy.hack.hibernate.entity.LuxuryHotel;
import com.happy.hack.hibernate.entity.RawTable;

import java.util.List;

/**
 * Created by freakster on 11/4/15.
 */
public interface LuxuryHotelDAO {

    void addRow(LuxuryHotel rw);
    List<LuxuryHotel> getAllData();





}
