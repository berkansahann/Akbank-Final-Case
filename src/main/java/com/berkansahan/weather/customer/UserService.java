package com.berkansahan.weather.customer;

import com.berkansahan.weather.customer.User;
import com.berkansahan.weather.customer.UserRepository;
import com.berkansahan.weather.openweathermap.WeatherDataResponse;
import com.berkansahan.weather.openweathermap.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author berkansahan
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    private final WeatherService weatherService;

    public User addSavedCityToUser(String city, Integer id) {
        User user = repository.findById(id).orElseThrow();
        List<String> cities = user.getSavedCities();
        if (cities == null) {
            cities = new ArrayList<>();
        }
        cities.add(city);
        user.setSavedCities(cities);
        repository.save(user);
        return user;
    }

    public Map<String, WeatherDataResponse> getSavedCitiesWeatherData(Integer id) {
        User user = repository.findById(id).orElseThrow();
        List<String> cities = user.getSavedCities();
        Map<String, WeatherDataResponse> citiesData = new HashMap<>();

        for (String city : cities) {
            citiesData.put(city, weatherService.getWeather(city));
        }
        return citiesData;
    }
}
