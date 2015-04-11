package com.happy.hack.hibernate.dao;

import com.happy.hack.hibernate.entity.AverageHotel;
import com.happy.hack.hibernate.entity.RawTable;

import java.util.List;

/**
 * Created by freakster on 11/4/15.
 */
public interface AverageHotelDAO {

    void addRow(AverageHotel rw);
    List<AverageHotel> getAllData();





}
