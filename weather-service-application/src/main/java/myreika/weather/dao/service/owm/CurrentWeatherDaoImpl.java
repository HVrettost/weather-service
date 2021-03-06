package myreika.weather.dao.service.owm;

import myreika.weather.client.OpenWeatherMapCurrentClient;
import myreika.weather.domain.Coordinates;
import myreika.weather.dto.CurrentWeatherDto;
import myreika.weather.dto.owm.current.CurrentWeather;

import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

@Component
public class CurrentWeatherDaoImpl implements CurrentWeatherDao {

    private final OpenWeatherMapCurrentClient openWeatherMapCurrentClient;
    private final ConversionService conversionService;

    public CurrentWeatherDaoImpl(OpenWeatherMapCurrentClient openWeatherMapCurrentClient,
                                 ConversionService conversionService) {
        this.openWeatherMapCurrentClient = openWeatherMapCurrentClient;
        this.conversionService = conversionService;
    }

    @Override
    public CurrentWeatherDto getCurrentWeatherByCity(String city, String units, String lang) {
        CurrentWeather currentWeather = openWeatherMapCurrentClient.getCurrentWeatherByCity(city, units, lang);
        return conversionService.convert(currentWeather, CurrentWeatherDto.class);
    }

    @Override
    public CurrentWeatherDto getCurrentWeatherByCityId(int cityId, String units, String lang) {
        CurrentWeather currentWeather = openWeatherMapCurrentClient.getCurrentWeatherByCityId(cityId, units, lang);
        return conversionService.convert(currentWeather, CurrentWeatherDto.class);
    }

    @Override
    public CurrentWeatherDto getCurrentWeatherByCoordinates(Coordinates coordinates, String units, String lang) {
        CurrentWeather currentWeather = openWeatherMapCurrentClient
                .getCurrentWeatherByCoordinates(coordinates.getLatitude(), coordinates.getLongitude(), units, lang);
        return conversionService.convert(currentWeather, CurrentWeatherDto.class);
    }

    @Override
    public CurrentWeatherDto getCurrentWeatherByZipCode(int zipCode, String units, String lang) {
        CurrentWeather currentWeather = openWeatherMapCurrentClient.getCurrentWeatherByZipCode(zipCode, units, lang);
        return conversionService.convert(currentWeather, CurrentWeatherDto.class);
    }
}
