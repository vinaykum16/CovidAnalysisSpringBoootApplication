package com.covid_analysis.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid_analysis.entity.WebData;

import jakarta.annotation.PostConstruct;

@Service
public class DistrictDetailsService {

	private String district;
	private List<WebData> districtData = new ArrayList<>();

	@Autowired
	private getSortedDataService gsds;

	public DistrictDetailsService() {
		this.district = "U.S. Nagar";
	}

	public DistrictDetailsService(String district) {
		this.district = district;
	}

	@PostConstruct
	public void ExtractDistrictDetails() {
		List<WebData> allDistrictList = gsds.getAllSortedStats();
		List<WebData> tempDistrictData = new ArrayList<>();
		for (WebData singleWebDataElement : allDistrictList) {
			if (singleWebDataElement.getDistrict().equals(district)) {
				tempDistrictData.add(singleWebDataElement);
			}
		}
		this.districtData = tempDistrictData;
	}

	public List<WebData> getDistrictDataWithParameter(String districtName) {

		ExtractDistrictDetails();
		return this.districtData;
	}

	public List<WebData> getDistrictData() {
		return this.districtData;
	}

}
