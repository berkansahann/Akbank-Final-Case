package com.berkansahan.weather.openweathermap;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author berkansahan
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/weather")
public class WeatherController {

    private final WeatherService weatherService;

    /**
     * Retrieves the weather data for the specified city.
     *
     * @param cityName the name of the city
     * @return the weather data response
     */
    @GetMapping("/{city}")
    public WeatherDataResponse getWeather(@PathVariable("city") String cityName) {
        return weatherService.getWeather(cityName);
    }
}
