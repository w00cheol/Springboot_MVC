package com.woo.hello.world;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.woo.hello.world.model.*;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
@RestController
@RequestMapping("/info")
public class InfoController {
	private InfoService infoService;
	
	public InfoController(InfoService infoService) {
		this.infoService = infoService;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(InfoController.class, args);
	}
	
	@GetMapping("")
	public Project getProjectInfo() {
		Project project = this.infoService.getProjectInfo();
		return project;
	}

	@GetMapping("/cityList")
	public List<City> getCityList() {
		List<City> cityList = this.infoService.getCityList();
		return cityList;
	}
	
	@GetMapping("/kr/cityList")
	public List<City> getKrCityList() {
		List<City> cityList = this.infoService.getKrCityList();
		return cityList;
	}
	
	@GetMapping("/cityListByCode")
	public List<City> findCityByCtCodePopulation(
			@RequestParam("countryCode") String ctCode,
			@RequestParam(value = "population", required = false, defaultValue = "0") int population) {
		List<City> cityList = this.infoService.findCityByCtCodePopulation(ctCode, population);
		return cityList;
	}
	
	@PostMapping("/city")
	public ResponseEntity<City> insertCity(@RequestBody City city) {
		this.infoService.insertCity(city);
		return new ResponseEntity<>(city, HttpStatus.OK);
	}
	
	@PostMapping("/city/{id}")
	public ResponseEntity<String> updateCity(@PathVariable(value="id") Integer id , @RequestBody City city) {
		this.infoService.updateCity(id, city);
		return new ResponseEntity<>("", HttpStatus.OK);
	}
	
	@DeleteMapping("/city/{id}")
	public ResponseEntity<String> deleteCity(@PathVariable(value="id") Integer id) {
		this.infoService.deleteCity(id);
		return new ResponseEntity<>("", HttpStatus.OK);
	}
}
