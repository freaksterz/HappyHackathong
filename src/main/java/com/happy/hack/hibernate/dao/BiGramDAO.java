package com.happy.hack.hibernate.dao;

import com.happy.hack.hibernate.entity.AverageHotel;
import com.happy.hack.hibernate.entity.BiGram;

import java.util.List;

/**
 * Created by freakster on 11/4/15.
 */
public interface BiGramDAO {

    void addRow(BiGram rw);
    List<BiGram> getAllData();





}
