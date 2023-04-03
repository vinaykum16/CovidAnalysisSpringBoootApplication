package com.covid_analysis.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid_analysis.entity.WebData;

import jakarta.annotation.PostConstruct;

@Service
public class TopNDistrictsService {
	private int num;

	@Autowired
	getSortedDataService sdService;

	private List<WebData> topNConsList;
	private List<WebData> singleDistrictData;

	public TopNDistrictsService() {
		this.num = 10;
	}

	public TopNDistrictsService(int n) {
		this.num = n;
	}

	@PostConstruct
	public void topNdistricts() {
		List<WebData> tempSortedListHolder = sdService.getAllSortedStats();
		List<WebData> singleDistrictAndStateHolder = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			WebData wbd = tempSortedListHolder.get(i);
			singleDistrictAndStateHolder.addAll(this.ExtractSingleDistrictDetails(wbd.getDistrict()));

		}
		this.topNConsList = singleDistrictAndStateHolder;
	}

	public List<WebData> ExtractSingleDistrictDetails(String district) {
		List<WebData> tempDistrictData = new ArrayList<>();
		List<WebData> allDistrictList = sdService.getAllSortedStats();

		for (WebData singleWebDataElement : allDistrictList) {
			if (singleWebDataElement.getDistrict().equals(district)) {

				tempDistrictData.add(singleWebDataElement);
			}
		}
		this.singleDistrictData = tempDistrictData;
		return this.singleDistrictData;
	}

	public List<WebData> getTopNConsListWithParameter(int n) {

		topNdistricts();
		return this.topNConsList;
	}

}
