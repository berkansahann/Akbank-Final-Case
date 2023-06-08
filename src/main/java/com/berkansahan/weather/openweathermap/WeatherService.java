package com.berkansahan.weather.openweathermap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author berkansahan
 */
@Service
@RequiredArgsConstructor
public class WeatherService {

    private final ObjectMapper objectMapper;
    private final WeatherFeignClient feignClient;
    private final WeatherConfig config;

    public WeatherDataResponse getWeather(String cityName){
        try {
            return objectMapper.readValue(feignClient.getWeatherData(cityName, config.getApiKey()),WeatherDataResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
