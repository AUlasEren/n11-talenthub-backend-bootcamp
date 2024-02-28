package com.ulas.weatherapiapp.mapper;

import com.ulas.weatherapiapp.dto.WeatherDTO;
import com.ulas.weatherapiapp.dto.WeatherResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface WeatherMapper {
    WeatherMapper INSTANCE = Mappers.getMapper(WeatherMapper.class);

    @Mapping(target = "city", source = "name")
    @Mapping(target = "country", source = "sys.country")
    @Mapping(target = "temperature", source = "main.temp")
    WeatherDTO convertToWeatherDTO(WeatherResponse response);
}


