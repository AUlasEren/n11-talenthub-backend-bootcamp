package com.ulas.weatherapiapp.errormessage;

import com.ulas.weatherapiapp.general.BaseErrorMessage;

public enum WeatherErrorMessage implements BaseErrorMessage {
    INVALID_REQUEST("Invalid request parameters."),
    WEATHER_DATA_NOT_FOUND("Weather data not found."),
    WEATHER_SERVICE_ERROR("Error occurred in weather service."),
    WEATHER_API_KEY_NOT_ALLOWED("Api key not allowed");

    private final String message;

    WeatherErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}


