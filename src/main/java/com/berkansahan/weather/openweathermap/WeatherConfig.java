package com.berkansahan.weather.openweathermap;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author berkansahan
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "open-weather-map")
public class WeatherConfig {

    private String apiKey;
}
