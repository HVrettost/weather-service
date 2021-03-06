package myreika.weather.dao.service.owm;

import myreika.weather.domain.Coordinates;
import myreika.weather.dto.CurrentWeatherDto;

public interface CurrentWeatherDao {

    CurrentWeatherDto getCurrentWeatherByCity(String city, String units, String lang);

    CurrentWeatherDto getCurrentWeatherByCityId(int cityId, String units, String lang);

    CurrentWeatherDto getCurrentWeatherByCoordinates(Coordinates coordinates, String units, String lang);

    CurrentWeatherDto getCurrentWeatherByZipCode(int zipCode, String units, String lang);
}
