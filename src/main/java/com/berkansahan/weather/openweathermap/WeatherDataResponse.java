package com.berkansahan.weather.openweathermap;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author berkansahan
 */
@Getter
@Setter
public class WeatherDataResponse {

    private String cod;
    private int message;
    private int cnt;
    private List<WeatherData> list;
    private City city;

    @Getter
    @Setter
    public static class WeatherData {
        private long dt;
        private MainData main;
        private List<Weather> weather;
        private Clouds clouds;
        private Wind wind;
        private int visibility;
        private int pop;
        private Sys sys;
        private String dt_txt;
    }

    @Getter
    @Setter
    public static class MainData {
        private double temp;
        private double feels_like;
        private double temp_min;
        private double temp_max;
        private int pressure;
        private int sea_level;
        private int grnd_level;
        private int humidity;
        private double temp_kf;
    }

    @Getter
    @Setter
    public static class Weather {
        private int id;
        private String main;
        private String description;
        private String icon;
    }

    @Getter
    @Setter
    public static class Clouds {
        private int all;
    }

    @Getter
    @Setter
    public static class Wind {
        private double speed;
        private int deg;
        private double gust;
    }

    @Getter
    @Setter
    public static class Sys {
        private String pod;
    }

    @Getter
    @Setter
    public static class City {
        private int id;
        private String name;
        private Coord coord;
        private String country;
        private int population;
        private int timezone;
        private long sunrise;
        private long sunset;
    }

    @Getter
    @Setter
    public static class Coord {
        private double lat;
        private double lon;
    }
}
