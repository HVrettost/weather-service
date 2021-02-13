package myreika.weather.service;

import myreika.weather.dto.openweathermap.current.CurrentWeather;

public interface CurrentWeatherService {

    CurrentWeather getCurrentWeatherByCity(String city);
}
