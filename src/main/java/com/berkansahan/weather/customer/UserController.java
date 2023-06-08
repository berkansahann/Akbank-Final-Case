package com.berkansahan.weather.customer;

import com.berkansahan.weather.generic.RestResponse;
import com.berkansahan.weather.openweathermap.WeatherDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author berkansahan
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService service;

    /**
     * Adds a saved city to the user's list of saved cities.
     *
     * @param city the city to add
     * @param id   the user ID
     * @return the response entity with the updated list of saved cities
     */

    @PostMapping("/new-city")
    public ResponseEntity<RestResponse<List<String>>> addSavedCityToUser(@RequestParam String city, @RequestParam Integer id) {
        List<String> cityList = service.addSavedCityToUser(city, id);
        return ResponseEntity.ok(RestResponse.of(cityList));
    }

    /**
     * Retrieves the weather data for the user's saved cities.
     *
     * @param id the user ID
     * @return the response entity with the map of city names to weather data
     */
    @GetMapping("/weather-data/saved-cities")
    public ResponseEntity<RestResponse<Map<String, WeatherDataResponse>>> getSavedCitiesWeatherDataOfUser(@RequestParam Integer id) {
        var response = service.getSavedCitiesWeatherData(id);
        return ResponseEntity.ok(RestResponse.of(response));
    }


}
