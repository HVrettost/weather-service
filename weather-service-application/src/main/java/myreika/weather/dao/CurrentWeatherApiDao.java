package myreika.weather.dao;

import myreika.weather.dto.openweathermap.current.CurrentWeather;

public interface CurrentWeatherApiDao {

    CurrentWeather getCurrentWeatherByCity(String city);
}
