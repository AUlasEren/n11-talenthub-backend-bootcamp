package com.ulas.weatherapiapp.service;

import com.ulas.weatherapiapp.dto.WeatherResponse;
import com.ulas.weatherapiapp.errormessage.WeatherErrorMessage;
import com.ulas.weatherapiapp.general.WeatherBusinessException;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${openweathermap.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherResponse getWeather(String country, String city, String frequency) {
        try {
            String url = buildUrl(country, city, frequency);
            return restTemplate.getForObject(url, WeatherResponse.class);
        } catch (RestClientException e) {
            throw new WeatherBusinessException(WeatherErrorMessage.WEATHER_API_KEY_NOT_ALLOWED);
        } catch (IllegalArgumentException e) {
            throw new WeatherBusinessException(WeatherErrorMessage.INVALID_REQUEST);
        }
    }

    private String buildUrl(String country, String city, String frequency) {
        String baseUrl = "http://api.openweathermap.org/data/2.5/";
        String apiKeyParam = "&appid=" + apiKey;
        String queryParam = "q=" + city + "," + country;
        String unitsParam = "&units=metric";

        switch (frequency) {
            case "daily":
                return baseUrl + "weather?" + queryParam + apiKeyParam + unitsParam;
            case "weekly":
                return baseUrl + "forecast/daily?" + queryParam + "&cnt=7" + apiKeyParam + unitsParam;
            case "monthly":
                return baseUrl + "forecast/daily?" + queryParam + "&cnt=30" + apiKeyParam + unitsParam;
            default:
                throw new IllegalArgumentException("Invalid frequency: " + frequency);
        }

    }
}


