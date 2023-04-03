package com.covid_analysis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.covid_analysis.entity.CovidData;

@Repository
public interface CovidDataRepo extends JpaRepository<CovidData, Integer> {

	@Query("SELECT cd.state FROM CovidDataEntity cd group by state")
	List<String> getStates();

	List<CovidData> findByState(String state);

	@Query("FROM CovidDataEntity cd where state=:state and confirmed > 0")
	List<CovidData> findByConfirmed(String state);

	List<CovidData> findByStateAndDistrict(String state, String district);

	@Query("select cd.date, cd.state, sum(cd.confirmed) as totalConfirmed " + "from CovidDataEntity cd "
			+ "where cd.state in (:firstState,:sectate) " + "and cd.date between :startDate and :endDate "
			+ "group by cd.state,cd.date order by cd.state, cd.date")
	List<Object[]> getBasedOnDateOf2States(String firstState, String sectate, String startDate, String endDate);

	@Query("select cd.date, cd.state, sum(cd.confirmed) as totalConfirmed " + "from CovidDataEntity cd "
			+ "where cd.date between :startDate and :endDate " + "group by cd.state,cd.date order by cd.state, cd.date")
	List<Object[]> getConfirmedCasesByDateRange(String startDate, String endDate);

}
