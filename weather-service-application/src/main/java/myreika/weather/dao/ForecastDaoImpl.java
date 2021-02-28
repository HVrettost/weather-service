package myreika.weather.dao;

import myreika.weather.client.OpenWeatherMapForecastClient;
import myreika.weather.domain.Coordinates;
import myreika.weather.dto.forecast.DailyForecastDto;
import myreika.weather.dto.owm.forecast.daily.DailyForecast;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

@Component
public class ForecastDaoImpl implements ForecastDao {

    private final OpenWeatherMapForecastClient openWeatherMapForecastClient;
    private final ConversionService conversionService;

    public ForecastDaoImpl(OpenWeatherMapForecastClient openWeatherMapForecastClient, ConversionService conversionService) {
        this.openWeatherMapForecastClient = openWeatherMapForecastClient;
        this.conversionService = conversionService;
    }

    @Override
    public DailyForecastDto getDailyForecastByCoordinates(Coordinates coordinates, String units, String lang) {
        DailyForecast dailyForecast = openWeatherMapForecastClient
                .getDailyForecastByCoordinates(coordinates.getLatitude(), coordinates.getLongitude(), units, lang);

        return conversionService.convert(dailyForecast, DailyForecastDto.class);
    }
}
