package com.berkansahan.weather.openweathermap;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author berkansahan
 */
@FeignClient(name = "OpenWeatherMapClient", url = "api.openweathermap.org/data/2.5/forecast")
public interface WeatherFeignClient {

    /**
     * Retrieves the weather data for the specified city using OpenWeatherMap API.
     *
     * @param cityName the name of the city
     * @param apiKey   the API key for accessing the OpenWeatherMap API
     * @return the weather data as a JSON string
     */
    @GetMapping
    String getWeatherData(@RequestParam("q") String cityName, @RequestParam("appid") String apiKey);
}