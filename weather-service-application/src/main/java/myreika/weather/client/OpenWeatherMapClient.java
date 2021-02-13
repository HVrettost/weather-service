package myreika.weather.client;

import myreika.weather.dto.openweathermap.current.CurrentWeather;

public interface OpenWeatherMapClient {

    CurrentWeather getCurrentWeatherByCity(String city);
}
