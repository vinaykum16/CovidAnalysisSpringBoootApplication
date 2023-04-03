package com.covid_analysis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.covid_analysis.entity.WebData;
import com.covid_analysis.services.getCsvDataService;

@Controller
public class getCsvDataController {

	@Autowired
	private getCsvDataService csvData;

	@GetMapping("/csvData")
	public String home(Model model) {
		List<WebData> allStats = csvData.getAllStats();
		int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getNewCases()).sum();
		model.addAttribute("locationStats", allStats);
		model.addAttribute("totalReportedCases", totalReportedCases);
		return "csvData";
	}

}
