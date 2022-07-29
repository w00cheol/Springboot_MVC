package com.woo.hello.world.repository;

public class CitySql {
	public String select() {
		return """
			SELECT
				ID, Name, CountryCode, District, Population
			FROM
				city
			LIMIT
				10;
		""";
	}
	public String findKr() {
		return """
			SELECT
				ID, Name, CountryCode, District, Population
			FROM
				city
			WHERE
				CountryCode = 'KOR' AND Population > 2000000
		""";
	}
	public String findCityByCtCodePopulation(String ctCode, int population) {
		return """
			SELECT
				ID, Name, CountryCode, District, Population
				
			FROM
				city
				
			WHERE
				1=1
			AND CountryCode = '""" + ctCode + """
		   'AND population >= """ + population + """
		""";
	}
	
	public String insertCity(int Id, String Name, String ctCode, String District, int population) {
		return """
			INSERT INTO
				city
				
			VALUES (
				  """ + Id + """
			   , '""" + Name + """
			  ', '""" + ctCode + """
			  ', '""" + District + """
			  ',  """ + population + """
			  )
		""";
	}
	
	public String updateCity(int Id, String Name, String ctCode, String District, int population) {
		return """
			UPDATE
				city
				
			SET
				Name = '""" + Name + """
			 ', CountryCode = '""" + ctCode + """
			 ', District = '""" + District + """
			 ', Population = """ + population + """
			 		
		    WHERE
			    ID = """ + Id + """
		""";
	}
	
	public String deleteCity(int Id) {
		return """
			DELETE FROM
				city
				
		    WHERE
			    ID = """ + Id + """
		""";
	}
}
