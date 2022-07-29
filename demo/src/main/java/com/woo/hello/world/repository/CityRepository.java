package com.woo.hello.world.repository;

import java.util.List;

import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.woo.hello.world.model.City;

@Repository
public class CityRepository {
	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private final CityRowMapper cityRowMapper;
	private final CitySql citySql;
	
	public CityRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
		this.cityRowMapper = new CityRowMapper();
		this.citySql = new CitySql();
	}

	public List<City> findList() { // if @param exits: new MapSqlParameterSource() instead EmptySqlParameterSource.INSATNCE
		return this.namedParameterJdbcTemplate.query(this.citySql.select(), EmptySqlParameterSource.INSTANCE, this.cityRowMapper);
	}
	
	public List<City> findKrList() { // if @param exits: new MapSqlParameterSource() instead EmptySqlParameterSource.INSATNCE
		return this.namedParameterJdbcTemplate.query(this.citySql.findKr(), EmptySqlParameterSource.INSTANCE, this.cityRowMapper);
	}

	public List<City> findCityByCtCodePopulation(String ctCode, int population) { // if @param exits: new MapSqlParameterSource() instead EmptySqlParameterSource.INSATNCE
		String sql = this.citySql.findCityByCtCodePopulation(ctCode, population);
		return this.namedParameterJdbcTemplate.query(sql, EmptySqlParameterSource.INSTANCE, this.cityRowMapper);
	}
	
	public Integer insertCity(City city) {
		String sql = this.citySql.insertCity(city.getId(), city.getName(), city.getCountryCode(), city.getDistrict(), city.getPopulation());
		return this.namedParameterJdbcTemplate.update(sql, EmptySqlParameterSource.INSTANCE);
	}
	
	public Integer updateCity(Integer id, City city) {
		String sql = this.citySql.updateCity(id, city.getName(), city.getCountryCode(), city.getDistrict(), city.getPopulation());
		return this.namedParameterJdbcTemplate.update(sql, EmptySqlParameterSource.INSTANCE);
	}
	
	public Integer deleteCity(Integer id) {
		String sql = this.citySql.deleteCity(id);
		return this.namedParameterJdbcTemplate.update(sql, EmptySqlParameterSource.INSTANCE);
	}
}