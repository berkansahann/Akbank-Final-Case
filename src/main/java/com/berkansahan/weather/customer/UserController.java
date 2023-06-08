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

    @PostMapping("/new-city")
    public ResponseEntity<RestResponse<List<String>>> addSavedCityToUser(@RequestParam String city, @RequestParam Integer id ){
        List<String> cityList = service.addSavedCityToUser(city, id);
        return ResponseEntity.ok(RestResponse.of(cityList));
    }

    @GetMapping("/weather-data/saved-cities")
    public ResponseEntity<RestResponse<Map<String, WeatherDataResponse>>> getSavedCitiesWeatherDataOfUser(@RequestParam Integer id){
        var response = service.getSavedCitiesWeatherData(id);
        return ResponseEntity.ok(RestResponse.of(response));
    }


}
