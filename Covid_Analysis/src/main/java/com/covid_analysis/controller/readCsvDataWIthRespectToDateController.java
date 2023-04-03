package com.covid_analysis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.covid_analysis.entity.NewWebData;
import com.covid_analysis.services.readCsvDataWithRespectToDate;

@Controller
public class readCsvDataWIthRespectToDateController {

	@Autowired
	private readCsvDataWithRespectToDate dateWiseData;

	@GetMapping("/date")
	public String home(Model model) {
		List<NewWebData> allStats = this.dateWiseData.getAllStats();
		model.addAttribute("allStats", allStats);
		return "date";
	}

}
