package com.covid_analysis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.covid_analysis.dto.ConfirmCovidCase;
import com.covid_analysis.entity.CovidData;
import com.covid_analysis.services.CovidDataService;

@RestController
public class CovidDataController {
	
	@Autowired
	private CovidDataService service;

	@RequestMapping("/")
	public String getHome() {
		return "Welcome!!!";
	}

	@RequestMapping("/states")
	public List<String> getStates() {
		return service.getStateNames();
	}

	@RequestMapping("/confirmed-cases")
	public List<CovidData> getStates(@RequestParam String state) {
		return service.findByConfirmed(state);
	}

	@RequestMapping("/confirmed-cases-based-on-state-and-district")
	public List<CovidData> getStates(@RequestParam String state, @RequestParam String district) {
		return service.findByStateAndDistrict(state, district);
	}

	@RequestMapping("/confirmed-cases-within-date-range")
	public List<ConfirmCovidCase> getConfirmedCasesByDateRange(@RequestParam String startDate,
			@RequestParam String endDate) {
		return service.getConfirmedCasesByDateRange(startDate, endDate);
	}

	@RequestMapping("/based-on-dates")
	public List<ConfirmCovidCase> getCasesBasedOnDates(@RequestParam String firstState,
			@RequestParam String secState, @RequestParam String startDate, @RequestParam String endDate) {

		return service.getBasedOnDateOf2States(firstState, secState, startDate, endDate);
	}


}
