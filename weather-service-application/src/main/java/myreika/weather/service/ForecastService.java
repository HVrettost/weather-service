package myreika.weather.service;

import myreika.weather.domain.Coordinates;
import myreika.weather.dto.forecast.DailyForecastDto;
import org.springframework.stereotype.Service;

@Service
public interface ForecastService {

    DailyForecastDto getDailyForecastByCoordinates(Coordinates coordinates, String units, String lang);
}
