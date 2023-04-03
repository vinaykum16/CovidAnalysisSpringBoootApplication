package com.covid_analysis.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid_analysis.entity.WebData;

import jakarta.annotation.PostConstruct;

@Service
public class getSortedDataService {

	private List<WebData> allStats2 = new ArrayList<>();

	@Autowired
	private getCsvDataService coVirusData;

	@PostConstruct
	public void fetchDataAndSort() throws IOException, InterruptedException {
		List<WebData> tempData = new ArrayList<>(this.coVirusData.getAllStats());
		Collections.sort(tempData, new Comparator<WebData>() {
			@Override
			public int compare(WebData o1, WebData o2) {
				return Integer.compare(o1.getNewCases(), o2.getNewCases());

			}
		});
		Collections.reverse(tempData);

		this.allStats2 = tempData;
	}

	public List<WebData> getAllSortedStats() {
		return this.allStats2;
	}

}
