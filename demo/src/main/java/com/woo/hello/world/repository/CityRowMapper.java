package com.woo.hello.world.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.woo.hello.world.model.City;

public class CityRowMapper implements RowMapper<City>{
	@Override // implements 로 인터페이스 상속했기때문 사용되는 함수 모두 재정의
	public City mapRow(ResultSet rs, int rowNum) throws SQLException {
		City city = new City();
		city.setId(rs.getInt("ID"));
		city.setName(rs.getString("Name"));
		city.setCountryCode(rs.getString("countrycode"));
		city.setDistrict(rs.getString("district"));
		city.setPopulation(rs.getInt("population"));
		return city;
	}
}