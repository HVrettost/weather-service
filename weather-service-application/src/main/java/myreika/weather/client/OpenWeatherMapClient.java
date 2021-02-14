package myreika.weather.client;

import myreika.weather.dto.owm.current.CurrentWeather;

public interface OpenWeatherMapClient {

    CurrentWeather getCurrentWeatherByCity(String city, String units, String lang);
}
