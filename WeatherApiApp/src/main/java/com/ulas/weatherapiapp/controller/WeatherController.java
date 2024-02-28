package com.ulas.weatherapiapp.controller;

import com.ulas.weatherapiapp.controller.contract.WeatherControllerContract;
import com.ulas.weatherapiapp.dto.WeatherDTO;
import com.ulas.weatherapiapp.general.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/weather")
public class WeatherController {

    private final WeatherControllerContract weatherControllerContract;

    public WeatherController(WeatherControllerContract weatherControllerContract) {
        this.weatherControllerContract = weatherControllerContract;
    }

    @GetMapping("/daily")
    public ResponseEntity<RestResponse<WeatherDTO>> getDailyWeather(@RequestParam String country, @RequestParam String city) {
        WeatherDTO weatherDTO = weatherControllerContract.getDailyWeather(country, city);
        return ResponseEntity.ok(RestResponse.of(weatherDTO).message("Daily weather data retrieved successfully."));
    }
    @GetMapping("/weekly")
    public ResponseEntity<RestResponse<WeatherDTO>> getWeeklyWeather(@RequestParam String country, @RequestParam String city) {
        WeatherDTO weatherDTO = weatherControllerContract.getWeeklyWeather(country, city);
        return ResponseEntity.ok(RestResponse.of(weatherDTO).message("Weekly weather data retrieved successfully."));
    }

    @GetMapping("/monthly")
    public ResponseEntity<RestResponse<WeatherDTO>> getMonthlyWeather(@RequestParam String country, @RequestParam String city) {
        WeatherDTO weatherDTO = weatherControllerContract.getMonthlyWeather(country, city);
        return ResponseEntity.ok(RestResponse.of(weatherDTO).message("Monthly weather data retrieved successfully."));
    }
}
