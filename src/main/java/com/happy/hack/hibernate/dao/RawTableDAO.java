package com.happy.hack.hibernate.dao;


import com.happy.hack.hibernate.entity.RawTable;

/**
 * Created by freakster on 11/4/15.
 */
public interface RawTableDAO {

    void addRow(RawTable rw);
    String getColumn(String columnname);





}
