package myreika.weather.service;

import myreika.weather.domain.Coordinates;
import myreika.weather.dto.CurrentWeatherDto;

public interface CurrentWeatherService {

    CurrentWeatherDto getCurrentWeatherByCity(String city, String units, String lang);

    CurrentWeatherDto getCurrentWeatherByCityId(int cityId, String units, String lang);

    CurrentWeatherDto getCurrentWeatherByCoordinates(Coordinates coordinates, String units, String lang);

    CurrentWeatherDto getCurrentWeatherByZipCode(int zipCode, String units, String lang);
}
