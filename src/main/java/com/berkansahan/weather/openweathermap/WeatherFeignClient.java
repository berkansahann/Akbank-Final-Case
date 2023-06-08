package com.berkansahan.weather.openweathermap;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author berkansahan
 */
@FeignClient(name = "OpenWeatherMapClient", url = "api.openweathermap.org/data/2.5/forecast")
public interface WeatherFeignClient {

    @GetMapping
    String getWeatherData(@RequestParam("q") String cityName, @RequestParam("appid") String apiKey);
}