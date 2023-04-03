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
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.covid_analysis.entity.NewWebData;

import jakarta.annotation.PostConstruct;

@Service
public class readCsvDataWithRespectToDate {

	private String csvURL = " ";

	private List<NewWebData> allStats = new ArrayList<>();

	private String dateSince = "01/01/2023";

	public void setDate(String dateSince) {
		this.dateSince = dateSince;
	}

	@PostConstruct
	public void fetchData() throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest rqst = HttpRequest.newBuilder().uri(URI.create(csvURL)).build();

		HttpResponse<String> rspns = client.send(rqst, HttpResponse.BodyHandlers.ofString());

		StringReader sr = new StringReader(rspns.body());
		CSVParser parser = CSVParser.parse(rspns.body(), CSVFormat.DEFAULT);
		CSVRecord header = parser.getRecords().get(0);

		ArrayList<Object> list = new ArrayList<>(header.size());
		for (int i = 0; i < header.size(); i++) {
			list.add(header.get(i));
		}

		int beginDateIndexNumber = (int) (list.indexOf(this.dateSince) - 1);
		String endDate = header.get(header.size() - 1);
		int endDateIndexNumber = list.indexOf(endDate);

		int countryNumber = 1;
		while (countryNumber < (endDateIndexNumber - 1)) {

			CSVParser parser2 = CSVParser.parse(rspns.body(), CSVFormat.DEFAULT);
			CSVRecord rcrd = parser2.getRecords().get(countryNumber);

			List<String> oneRowOfCsv = new ArrayList<>(rcrd.size());

			for (int i = 0; i < (rcrd.size() - 1); i++) {
				oneRowOfCsv.add(rcrd.get(i));
			}

			List<String> lst = oneRowOfCsv.subList(beginDateIndexNumber, (oneRowOfCsv.size()));

			this.allStats.add(new NewWebData(oneRowOfCsv.get(1), oneRowOfCsv.get(0), lst));
			countryNumber++;
		}
	}

	@Bean
	public List<NewWebData> getAllStats() {
		return allStats;
	}
}
