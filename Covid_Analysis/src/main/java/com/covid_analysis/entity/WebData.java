package com.covid_analysis.entity;

public class WebData {
	
	private String district;
    private String state;
    private int NewCases;
    
	@Override
	public String toString() {
		return "WebData [district=" + district + ", state=" + state + ", NewCases=" + NewCases + "]";
	}
	public String getDistrict() {
		return district;
	}
	public WebData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WebData(String district, String state, int newCases) {
		super();
		this.district = district;
		this.state = state;
		NewCases = newCases;
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
	public int getNewCases() {
		return NewCases;
	}
	public void setNewCases(int newCases) {
		NewCases = newCases;
	}

}
