package com.ulas.weatherapiapp.controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.ulas.weatherapiapp.controller.contract.WeatherControllerContract;
import com.ulas.weatherapiapp.dto.WeatherDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebMvcTest(WeatherController.class)
class WeatherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;
    @MockBean
    private WeatherControllerContract weatherControllerContract;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void getDailyWeatherTest() throws Exception {
        String country = "USA";
        String city = "New York";
        WeatherDTO mockWeatherDTO = new WeatherDTO(city, country, 20.0);


        Mockito.when(weatherControllerContract.getDailyWeather(country, city)).thenReturn(mockWeatherDTO);

        mockMvc.perform(get("/api/v1/weather/daily")
                        .param("country", country)
                        .param("city", city))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isNotEmpty());
    }

    @Test
    void getWeeklyWeatherTest() throws Exception {
        String country = "USA";
        String city = "New York";
        WeatherDTO mockWeatherDTO = new WeatherDTO(city, country, 20.0);


        Mockito.when(weatherControllerContract.getWeeklyWeather(country, city)).thenReturn(mockWeatherDTO);

        mockMvc.perform(get("/api/v1/weather/weekly")
                        .param("country", country)
                        .param("city", city))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isNotEmpty());
    }


    @Test
    void getMonthlyWeatherTest() throws Exception {
        String country = "USA";
        String city = "New York";
        WeatherDTO mockWeatherDTO = new WeatherDTO(city, country, 20.0); // Sahte bir DTO oluştur

        // Mock davranışını ayarla
        Mockito.when(weatherControllerContract.getMonthlyWeather(country, city)).thenReturn(mockWeatherDTO);

        mockMvc.perform(get("/api/v1/weather/monthly")
                        .param("country", country)
                        .param("city", city))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isNotEmpty());
    }
}


