package myreika.weather.dao;

import myreika.weather.dto.CurrentWeatherDto;

public interface CurrentWeatherDao {

    CurrentWeatherDto getCurrentWeatherByCity(String city, String units, String lang);

    CurrentWeatherDto getCurrentWeatherByCityId(String cityId, String units, String lang);

    CurrentWeatherDto getCurrentWeatherByCoordinates(double latitude, double longitude, String units, String lang);

    CurrentWeatherDto getCurrentWeatherByZipCode(String zipCode, String units, String lang);
}
