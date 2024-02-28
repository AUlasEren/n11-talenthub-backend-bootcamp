package com.ulas.weatherapiapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherResponse {
    private Long id;
    private String name;
    private  SysResponse sys;
    private MainResponse main;


}

