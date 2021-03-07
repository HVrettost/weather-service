package myreika.weather.dao.service.owm;

import myreika.weather.client.OpenWeatherMapForecastClient;
import myreika.weather.domain.Coordinates;
import myreika.weather.dto.forecast.daily.DailyForecastDto;
import myreika.weather.dto.forecast.hourly.HourlyForecastDto;
import myreika.weather.dto.forecast.minutely.MinutelyForecastDto;
import myreika.weather.dto.owm.forecast.daily.DailyForecast;
import myreika.weather.dto.owm.forecast.hourly.HourlyForecast;
import myreika.weather.dto.owm.forecast.minutely.MinutelyForecast;
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

    @Override
    public HourlyForecastDto getHourlyForecastByCoordinates(Coordinates coordinates, String units, String lang) {
        HourlyForecast hourlyForecast = openWeatherMapForecastClient
                .getHourlyForecastByCoordinates(coordinates.getLatitude(), coordinates.getLongitude(), units, lang);

        return conversionService.convert(hourlyForecast, HourlyForecastDto.class);
    }

    @Override
    public MinutelyForecastDto getMinutelyForecastByCoordinates(Coordinates coordinates, String units, String lang) {
        MinutelyForecast hourlyForecast = openWeatherMapForecastClient
                .getMinutelyForecastByCoordinates(coordinates.getLatitude(), coordinates.getLongitude(), units, lang);

        return conversionService.convert(hourlyForecast, MinutelyForecastDto.class);
    }
}
