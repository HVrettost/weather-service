package myreika.weather.dao;

import myreika.weather.dto.owm.current.CurrentWeatherDto;

public interface CurrentWeatherApiDao {

    CurrentWeatherDto getCurrentWeatherByCity(String city, String units, String lang);
}
