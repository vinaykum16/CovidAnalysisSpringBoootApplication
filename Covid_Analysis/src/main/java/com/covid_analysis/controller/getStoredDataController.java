package com.covid_analysis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.covid_analysis.entity.WebData;
import com.covid_analysis.services.getSortedDataService;

@Controller
public class getStoredDataController {

	@Autowired
	private getSortedDataService sortedData;

	@GetMapping("/highest")
	public String highCases(Model model2) {
		List<WebData> sortedStats = sortedData.getAllSortedStats();
		int totalReportedCases = sortedStats.stream().mapToInt(stat -> stat.getNewCases()).sum();
		model2.addAttribute("sortedStats", sortedStats);
		model2.addAttribute("totalReportedCases", totalReportedCases);
		return "highest";
	}

}
