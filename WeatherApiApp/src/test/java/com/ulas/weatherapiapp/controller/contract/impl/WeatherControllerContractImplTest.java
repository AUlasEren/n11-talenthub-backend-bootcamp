package com.ulas.weatherapiapp.controller.contract.impl;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


import com.ulas.weatherapiapp.dto.WeatherDTO;
import com.ulas.weatherapiapp.dto.WeatherResponse;
import com.ulas.weatherapiapp.service.WeatherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class WeatherControllerContractImplTest {

    @Mock
    private WeatherService weatherService;

    @InjectMocks
    private WeatherControllerContractImpl weatherControllerContract;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldGetDailyWeather() {
        String country = "TestCountry";
        String city = "TestCity";
        WeatherResponse mockResponse = new WeatherResponse();
        WeatherDTO expectedDto = new WeatherDTO(city, country, 20.0);

        when(weatherService.getWeather(country, city, "daily")).thenReturn(mockResponse);

        WeatherDTO result = weatherControllerContract.getDailyWeather(country, city);

        assertNotNull(result); // Daha spesifik doğrulamalar yapılabilir


        verify(weatherService).getWeather(country, city, "daily");
    }
    @Test
    public void shouldGetWeeklyWeather() {
        String country = "TestCountry";
        String city = "TestCity";
        WeatherResponse mockResponse = new WeatherResponse();
        WeatherDTO expectedDto = new WeatherDTO(city, country, 20.0);

        when(weatherService.getWeather(country, city, "weekly")).thenReturn(mockResponse);

        WeatherDTO result = weatherControllerContract.getWeeklyWeather(country, city);

        assertNotNull(result);
        verify(weatherService).getWeather(country, city, "weekly");
    }
    @Test
    public void shouldGetMonthlyWeather() {
        String country = "TestCountry";
        String city = "TestCity";
        WeatherResponse mockResponse = new WeatherResponse();
        WeatherDTO expectedDto = new WeatherDTO(city, country, 20.0);

        when(weatherService.getWeather(country, city, "monthly")).thenReturn(mockResponse);

        WeatherDTO result = weatherControllerContract.getMonthlyWeather(country, city);

        assertNotNull(result);
        verify(weatherService).getWeather(country, city, "monthly");
    }

}


