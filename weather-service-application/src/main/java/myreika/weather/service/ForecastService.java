package myreika.weather.service;

import myreika.weather.domain.Coordinates;
import myreika.weather.dto.forecast.daily.DailyForecastDto;
import myreika.weather.dto.forecast.hourly.HourlyForecastDto;
import myreika.weather.dto.forecast.minutely.MinutelyForecastDto;
import org.springframework.stereotype.Service;

@Service
public interface ForecastService {

    DailyForecastDto getDailyForecastByCoordinates(Coordinates coordinates, String units, String lang);

    HourlyForecastDto getHourlyForecastByCoordinates(Coordinates coordinates, String units, String lang);

    MinutelyForecastDto getMinutelyForecastByCoordinates(Coordinates coordinates, String units, String lang);
}
