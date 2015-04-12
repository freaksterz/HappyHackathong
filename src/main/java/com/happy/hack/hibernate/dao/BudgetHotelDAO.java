package com.happy.hack.hibernate.dao;

import com.happy.hack.hibernate.entity.BiGramBudget;
import com.happy.hack.hibernate.entity.BudgetHotel;
import com.happy.hack.hibernate.entity.RawTable;

import java.util.List;

/**
 * Created by freakster on 11/4/15.
 */
public interface BudgetHotelDAO {

    void addRow(BiGramBudget rw);
    List<BudgetHotel> getAllData();





}
