package myreika.weather.client;

import myreika.weather.dto.owm.current.CurrentWeather;

public interface OpenWeatherMapCurrentClient {

    CurrentWeather getCurrentWeatherByCity(String city, String units, String lang);

    CurrentWeather getCurrentWeatherByCityId(int cityId, String units, String lang);

    CurrentWeather getCurrentWeatherByCoordinates(double latitude, double longitude, String units, String lang);

    CurrentWeather getCurrentWeatherByZipCode(int zipCode, String units, String lang);
}
