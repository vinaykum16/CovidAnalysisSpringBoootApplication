package com.Covid_Analysis;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.covid_analysis.exception.InvalidDateException;
import com.covid_analysis.exception.InvalidDateRangeException;

@SpringBootTest
public class TestRecords {
	
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
	
	
@Test
	void contextLoads() {
	}

}
