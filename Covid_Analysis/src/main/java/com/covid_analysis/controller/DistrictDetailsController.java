package com.covid_analysis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.covid_analysis.entity.WebData;
import com.covid_analysis.services.DistrictDetailsService;

@Controller
public class DistrictDetailsController {

	private String districtName = "U.S Nagar";

	@Autowired
	DistrictDetailsService singleDistrict;

	@GetMapping("/district")
	public String highCases(Model model3) {
		List<WebData> districtData = singleDistrict.getDistrictDataWithParameter(districtName);
		model3.addAttribute("districtData", districtData);
		model3.addAttribute("districtName", districtName);
		return "district";
	}

	public String getDistrictName() {
		return districtName;
	}

	public DistrictDetailsService getSingleDistrict() {
		return singleDistrict;
	}

}
