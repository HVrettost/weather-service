package myreika.weather.service;

import myreika.weather.dto.owm.current.CurrentWeatherDto;

public interface CurrentWeatherService {

    CurrentWeatherDto getCurrentWeatherByCity(String city, String units, String lang);
}
