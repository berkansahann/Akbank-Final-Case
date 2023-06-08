package com.berkansahan.weather.customer;

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

    /**
     * Adds a saved city to the user's list of saved cities.
     *
     * @param city the city to add
     * @param id   the user ID
     * @return the updated list of saved cities
     */
    public List<String> addSavedCityToUser(String city, Integer id) {
        User user = repository.findById(id).orElseThrow();
        List<String> cities = user.getSavedCities();
        if (cities == null) {
            cities = new ArrayList<>();
        }
        cities.add(city);
        user.setSavedCities(cities);
        repository.save(user);
        return user.getSavedCities();
    }

    /**
     * Retrieves the weather data for the user's saved cities.
     *
     * @param id the user ID
     * @return a map of city names to weather data
     */
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
