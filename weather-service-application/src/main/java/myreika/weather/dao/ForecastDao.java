package myreika.weather.dao;

import myreika.weather.domain.Coordinates;
import myreika.weather.dto.forecast.DailyForecastDto;

public interface ForecastDao {

    DailyForecastDto getDailyForecastByCoordinates(Coordinates coordinates, String units, String lang);
}
