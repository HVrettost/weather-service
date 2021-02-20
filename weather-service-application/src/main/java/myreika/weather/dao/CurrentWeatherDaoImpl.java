package myreika.weather.dao;

import myreika.weather.client.OpenWeatherMapClient;
import myreika.weather.dto.CurrentWeatherDto;
import myreika.weather.dto.owm.current.CurrentWeather;

import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

@Component
public class CurrentWeatherDaoImpl implements CurrentWeatherDao {

    private final OpenWeatherMapClient openWeatherMapClient;
    private final ConversionService conversionService;

    public CurrentWeatherDaoImpl(OpenWeatherMapClient openWeatherMapClient,
                                 ConversionService conversionService) {
        this.openWeatherMapClient = openWeatherMapClient;
        this.conversionService = conversionService;
    }

    @Override
    public CurrentWeatherDto getCurrentWeatherByCity(String city, String units, String lang) {
        CurrentWeather currentWeather = openWeatherMapClient.getCurrentWeatherByCity(city, units, lang);
        return conversionService.convert(currentWeather, CurrentWeatherDto.class);
    }

    @Override
    public CurrentWeatherDto getCurrentWeatherByCityId(String cityId, String units, String lang) {
        CurrentWeather currentWeather = openWeatherMapClient.getCurrentWeatherByCityId(cityId, units, lang);
        return conversionService.convert(currentWeather, CurrentWeatherDto.class);
    }

    @Override
    public CurrentWeatherDto getCurrentWeatherByCoordinates(double latitude, double longitude, String units, String lang) {
        CurrentWeather currentWeather = openWeatherMapClient.getCurrentWeatherByCoordinates(latitude, longitude, units, lang);
        return conversionService.convert(currentWeather, CurrentWeatherDto.class);
    }

    @Override
    public CurrentWeatherDto getCurrentWeatherByZipCode(String zipCode, String units, String lang) {
        CurrentWeather currentWeather = openWeatherMapClient.getCurrentWeatherByZipCode(zipCode, units, lang);
        return conversionService.convert(currentWeather, CurrentWeatherDto.class);
    }
}
