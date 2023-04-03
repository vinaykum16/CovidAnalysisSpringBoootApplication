package com.covid_analysis.dto;

import java.io.Serializable;

public class ConfirmCovidCase implements Serializable, Cloneable{
	
	private String date;
	private String stateCode;
	private Double totalConfirmed;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public Double getTotalConfirmed() {
		return totalConfirmed;
	}
	public void setTotalConfirmed(Double totalConfirmed) {
		this.totalConfirmed = totalConfirmed;
	}
	@Override
	public String toString() {
		return "ConfirmCovidCase [date=" + date + ", stateCode=" + stateCode + ", totalConfirmed=" + totalConfirmed
				+ "]";
	}
	public ConfirmCovidCase(String date, String stateCode, Double totalConfirmed) {
		super();
		this.date = date;
		this.stateCode = stateCode;
		this.totalConfirmed = totalConfirmed;
	}
	public ConfirmCovidCase() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
