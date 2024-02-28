package com.ulas.weatherapiapp.excepiton;

import com.ulas.weatherapiapp.general.BaseErrorMessage;

public class WeatherNotFoundException extends RuntimeException {

public WeatherNotFoundException(BaseErrorMessage baseErrorMessage) {
    super(baseErrorMessage.getMessage());
}
}

