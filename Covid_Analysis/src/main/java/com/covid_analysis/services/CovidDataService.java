package com.covid_analysis.services;

import java.util.List;

import com.covid_analysis.dto.ConfirmCovidCase;
import com.covid_analysis.entity.CovidData;

public interface CovidDataService {

	List<String> getStateNames();

	List<CovidData> findDistrictByState(String stateCode);

	List<CovidData> getDataByStateInDateRange();

	List<CovidData> findByConfirmed(String state);

	List<CovidData> findByStateAndDistrict(String state, String district);

	List<ConfirmCovidCase> getBasedOnDateOf2States(String firstState, String sectate, String startDate, String endDate);

	List<ConfirmCovidCase> getConfirmedCasesByDateRange(String startDate, String endDate);

}
