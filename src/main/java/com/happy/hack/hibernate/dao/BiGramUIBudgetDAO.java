package com.happy.hack.hibernate.dao;

import com.happy.hack.hibernate.entity.BiGramUibudget;

import java.util.List;
import java.util.Map;

public interface BiGramUIBudgetDAO {
	void addRow(BiGramUibudget bl);

    List<Map<String, String>> getBiGramInteger(float value, float rooms, float locations, float cleanliness, float checkIn, float service, float businessService);
}
