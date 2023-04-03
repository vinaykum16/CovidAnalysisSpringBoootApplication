package com.covid_analysis.services;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.covid_analysis.entity.WebData;

import jakarta.annotation.PostConstruct;

@Service
public class getCsvDataService {

	private String csvURL = " ";

	private List<WebData> allStats = new ArrayList<>();

	@PostConstruct
	public void fetchData() throws IOException, InterruptedException {
		List<WebData> tempData = new ArrayList<>();
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest rqst = HttpRequest.newBuilder().uri(URI.create(csvURL)).build();

		HttpResponse<String> rspns = client.send(rqst, HttpResponse.BodyHandlers.ofString());

		StringReader sr = new StringReader(rspns.body());
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(sr);
		for (CSVRecord record : records) {

			WebData wd = new WebData();
			wd.setDistrict(record.get("District/Region"));
			wd.setState(record.get("Province/State"));
			wd.setNewCases(Integer.parseInt(record.get(record.size() - 1)));

			tempData.add(wd);

		}
		this.allStats = tempData;

	}

	public List<WebData> getAllStats() {
		return allStats;
	}

}
