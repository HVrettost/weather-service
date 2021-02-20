package myreika.weather.client;

import myreika.weather.dto.owm.current.CurrentWeather;

public interface OpenWeatherMapClient {

    CurrentWeather getCurrentWeatherByCity(String city, String units, String lang);

    CurrentWeather getCurrentWeatherByCityId(String cityId, String units, String lang);

    CurrentWeather getCurrentWeatherByCoordinates(double latitude, double longitude, String units, String lang);

    CurrentWeather getCurrentWeatherByZipCode(String zipCode, String units, String lang);
}
