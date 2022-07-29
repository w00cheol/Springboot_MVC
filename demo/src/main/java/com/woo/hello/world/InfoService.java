package com.woo.hello.world;

import java.util.Date;

import java.util.List;

import org.springframework.stereotype.Service;

import com.woo.hello.world.model.*;
import com.woo.hello.world.repository.*;

@Service
public class InfoService {
	private CityRepository cityRepository;
	
	public InfoService(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}
	
	public Project getProjectInfo() {
		Project project = new Project();
		project.projectName = "hello world";
		project.author = "Woo";
		project.createdDate = new Date();
		
		return project;
	}
	
	public List<City> getCityList() { 
		return this.cityRepository.findList();
	}

	public List<City> getKrCityList() { 
		return this.cityRepository.findKrList();
	}
	
	public List<City> findCityByCtCodePopulation(String ctCode, int population) { 
		return this.cityRepository.findCityByCtCodePopulation(ctCode, population);
	}

	public Integer insertCity(City city) { 
		return this.cityRepository.insertCity(city);
	}
	
	public Integer updateCity(Integer id, City city) { 
		return this.cityRepository.updateCity(id, city);
	}
	
	public Integer deleteCity(Integer id) { 
		return this.cityRepository.deleteCity(id);
	}
}
