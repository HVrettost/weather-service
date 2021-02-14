package myreika.weather.client;

import myreika.weather.dto.owm.current.CurrentWeatherDto;

public interface OpenWeatherMapClient {

    CurrentWeatherDto getCurrentWeatherByCity(String city, String units, String lang);
}
