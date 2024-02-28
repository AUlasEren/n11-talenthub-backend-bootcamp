package com.ulas.weatherapiapp.controller.contract.impl;

import com.ulas.weatherapiapp.controller.contract.WeatherControllerContract;
import com.ulas.weatherapiapp.dto.WeatherDTO;
import com.ulas.weatherapiapp.dto.WeatherResponse;
import com.ulas.weatherapiapp.errormessage.WeatherErrorMessage;
import com.ulas.weatherapiapp.general.WeatherBusinessException;
import com.ulas.weatherapiapp.mapper.WeatherMapper;
import com.ulas.weatherapiapp.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WeatherControllerContractImpl implements WeatherControllerContract {

    private final WeatherService weatherService;

    @Override
    public WeatherDTO getDailyWeather(String country, String city) {
        try {
            WeatherResponse response = weatherService.getWeather(country, city, "daily");
            return WeatherMapper.INSTANCE.convertToWeatherDTO(response);
        } catch (IllegalArgumentException e) {
            throw new WeatherBusinessException(WeatherErrorMessage.WEATHER_API_KEY_NOT_ALLOWED);
        }
    }


    @Override
    public WeatherDTO getWeeklyWeather(String country, String city) {
        try {
            WeatherResponse response = weatherService.getWeather(country, city, "weekly");
            return WeatherMapper.INSTANCE.convertToWeatherDTO(response);
        } catch (IllegalArgumentException e) {
            throw new WeatherBusinessException(WeatherErrorMessage.WEATHER_API_KEY_NOT_ALLOWED);
        }
    }

    @Override
    public WeatherDTO getMonthlyWeather(String country, String city) {
        try {
            WeatherResponse response = weatherService.getWeather(country, city, "monthly");
            return WeatherMapper.INSTANCE.convertToWeatherDTO(response);
        } catch (IllegalArgumentException e) {
            throw new WeatherBusinessException(WeatherErrorMessage.WEATHER_API_KEY_NOT_ALLOWED);
        }
    }
}
