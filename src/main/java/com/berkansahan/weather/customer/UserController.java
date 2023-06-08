package com.berkansahan.weather.customer;

import com.berkansahan.weather.openweathermap.WeatherDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
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
    public ResponseEntity<User> addSavedCityToUser(@RequestParam String city, @RequestParam Integer id ){
        var response = service.addSavedCityToUser(city, id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/weatherdata/savedcities")
    public ResponseEntity<Map<String, WeatherDataResponse>> getSavedCitiesWeatherDataOfUser(@RequestParam Integer id){
        var response = service.getSavedCitiesWeatherData(id);
        return ResponseEntity.ok(response);
    }


}
