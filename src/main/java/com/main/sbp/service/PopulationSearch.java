package com.main.sbp.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class PopulationSearch {

	public int getPopulation(String city) {
		
		Map<String, Integer> populationMap = null;
		int populationCount = 0;
		
		if (city.isEmpty()) {
			throw new NullPointerException("Input shouldn't be Empty");
		}
		
		populationMap = getPopulationStatistics();
		if (!populationMap.containsKey(city)) {
			throw new NullPointerException("Invalid input");
		} else {
			populationCount = populationMap.get(city);
		}
		
		return populationCount;
	}
	
	private Map<String, Integer> getPopulationStatistics() {
		Map<String, Integer> populationMap = new HashMap<String, Integer>();
		populationMap.put("Mumbai", 800000);
		populationMap.put("Pune", 400000);
		populationMap.put("Bangalore", 300000);
		populationMap.put("Hyderabad", 200000);
		return populationMap;
		
	}

}
