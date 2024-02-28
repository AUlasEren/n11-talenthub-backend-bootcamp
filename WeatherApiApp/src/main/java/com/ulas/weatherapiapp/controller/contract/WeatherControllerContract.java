package com.ulas.weatherapiapp.controller.contract;

import com.ulas.weatherapiapp.dto.WeatherDTO;

public interface WeatherControllerContract {
    WeatherDTO getDailyWeather(String country, String city);
    WeatherDTO getWeeklyWeather(String country, String city);
    WeatherDTO getMonthlyWeather(String country, String city);
}
