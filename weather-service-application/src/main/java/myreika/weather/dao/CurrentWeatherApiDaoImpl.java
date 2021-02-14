package myreika.weather.dao;

import myreika.weather.client.OpenWeatherMapClient;
import myreika.weather.dto.CurrentWeatherDto;
import myreika.weather.dto.owm.current.CurrentWeather;

import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

@Component
public class CurrentWeatherApiDaoImpl implements CurrentWeatherApiDao {

    private final OpenWeatherMapClient openWeatherMapClient;
    private final ConversionService conversionService;

    public CurrentWeatherApiDaoImpl(OpenWeatherMapClient openWeatherMapClient,
                                    ConversionService conversionService) {
        this.openWeatherMapClient = openWeatherMapClient;
        this.conversionService = conversionService;
    }

    @Override
    public CurrentWeatherDto getCurrentWeatherByCity(String city, String units, String lang) {
        CurrentWeather currentWeather = openWeatherMapClient.getCurrentWeatherByCity(city, units, lang);
        return conversionService.convert(currentWeather, CurrentWeatherDto.class);
    }
}
