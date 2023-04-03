package com.covid_analysis.services.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.covid_analysis.dto.ConfirmCovidCase;
import com.covid_analysis.entity.CovidData;
import com.covid_analysis.exception.InvalidDateException;
import com.covid_analysis.exception.InvalidDateRangeException;
import com.covid_analysis.exception.InvalidStateCodeException;
import com.covid_analysis.repository.CovidDataRepo;
import com.covid_analysis.services.CovidDataService;

public class CovidDataServiceImpl implements CovidDataService {

	@Autowired
	private CovidDataRepo cdRepo;

	@Override
	public List<String> getStateNames() {
		List<String> states = cdRepo.getStates();
		states.forEach(System.out::println);
		return states;
	}

	@Override
	public List<CovidData> findDistrictByState(String stateCode) {
		List<CovidData> covidDataEntities = cdRepo.findByState(stateCode);
		if (covidDataEntities != null && !covidDataEntities.isEmpty()) {
		} else {
			throw new InvalidStateCodeException("Please Enter A Vaild StateCode");
		}

		return covidDataEntities;
	}

	@Override
	public List<CovidData> getDataByStateInDateRange() {
		return null;
	}

	@Override
	public List<CovidData> findByConfirmed(String state) {
		return cdRepo.findByConfirmed(state);
	}

	@Override
	public List<CovidData> findByStateAndDistrict(String state, String district) {
		return cdRepo.findByStateAndDistrict(state, district);
	}

	@Override
	public List<ConfirmCovidCase> getBasedOnDateOf2States(String firstState, String sectate, String startDate,
			String endDate) {
		return null;
	}

	@Override
	public List<ConfirmCovidCase> getConfirmedCasesByDateRange(String startDate, String endDate) {
		return null;
	}

	private List<ConfirmCovidCase> dtoMapper(List<Object[]> result) {
		List<ConfirmCovidCase> dtos = new ArrayList<ConfirmCovidCase>();
		String date = null;
		String stateCode = null;
		Double confirmedTotal = null;
		for (Object[] objects : result) {

			date = String.valueOf(objects[0] == null ? "" : objects[0]);
			stateCode = String.valueOf(objects[1] == null ? "" : objects[1]);
			confirmedTotal = Double.parseDouble(String.valueOf(objects[2] == null ? "0" : objects[2]));

			ConfirmCovidCase dto = new ConfirmCovidCase();
			dtos.add(dto);
		}

		return dtos;
	}

	private Date isValidFormat(String dateStr) {
		Date dt = null;
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		try {
			boolean isVF = dateStr.matches("(([0-9]{4}-[0-9]{2})-([0-9]{2}))");
			if (isVF) {
				dt = sdf.parse(dateStr);
			}
		} catch (ParseException e) {
			System.out.println("Exception : " + e.getMessage());
			return dt;
		}
		return dt;
	}

	private void isValidDate(String startDate, String endDate) {
		Date stDt = isValidFormat(startDate);
		Date endDt = isValidFormat(endDate);

		if (stDt != null && endDt != null) {
			if (!stDt.before(endDt)) {
				throw new InvalidDateRangeException("Invalid Date Range, Please check your input");
			}
		} else if (stDt == null) {
			throw new InvalidDateException("Invalid Start date, please check your input");
		} else if (endDt == null) {
			throw new InvalidDateException("Invalid End date, please check your input");
		}
	}

}
