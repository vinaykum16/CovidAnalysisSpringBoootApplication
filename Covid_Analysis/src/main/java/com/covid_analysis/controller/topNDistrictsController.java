package com.covid_analysis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.covid_analysis.entity.WebData;
import com.covid_analysis.services.TopNDistrictsService;

@Controller
public class topNDistrictsController {

	private int n = 10;
	@Autowired
	TopNDistrictsService topNDistricts;

	@GetMapping("/topNDistricts")
	public String highCases(Model model) {
		List<WebData> districtsData = topNDistricts.getTopNConsListWithParameter(n);
		model.addAttribute("districtData", districtsData);
		return "topNCountries";
	}

}
