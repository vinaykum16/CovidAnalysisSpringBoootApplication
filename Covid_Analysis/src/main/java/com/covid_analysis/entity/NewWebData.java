package com.covid_analysis.entity;

import java.util.ArrayList;
import java.util.List;

public class NewWebData {
	
	private String district;
    private String state;
    private List<String> CasesInASingleDay;
    
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<String> getCasesInASingleDay() {
		return CasesInASingleDay;
	}
	public void setCasesInASingleDay(List<String> casesInASingleDay) {
		CasesInASingleDay = casesInASingleDay;
	}
	@Override
	public String toString() {
		return "NewWebData [district=" + district + ", state=" + state + ", CasesInASingleDay=" + CasesInASingleDay
				+ "]";
	}
	public NewWebData(String district, String state, List<String> casesInASingleDay) {
		super();
		this.district = district;
		this.state = state;
		this.CasesInASingleDay = casesInASingleDay;
	}
	
	public void setCasesInASingleDay(String district, String state, List<String> casesInASingleDay) {
        this.district = district;
        this.state = state;
        this.CasesInASingleDay = casesInASingleDay;
    }
    
	public NewWebData setItAll(NewWebData nwd){
	    this.district = nwd.district;
	    this.state = nwd.state;
	    this.CasesInASingleDay = nwd.CasesInASingleDay;
	    return this;
	}

	public void addCase(List<String> casesInASingleDay){
		this.CasesInASingleDay.addAll(casesInASingleDay);
	}

	public void addCase(String addNew){
		this.CasesInASingleDay.add(addNew);
	}
    
	public NewWebData() {
		district = "Default";
		state = "State";
		CasesInASingleDay = new ArrayList<>();
	}

}
