package myreika.weather.dao;

import myreika.weather.dto.CurrentWeatherDto;

public interface CurrentWeatherApiDao {

    CurrentWeatherDto getCurrentWeatherByCity(String city, String units, String lang);
}
