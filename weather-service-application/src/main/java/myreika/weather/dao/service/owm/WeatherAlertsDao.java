package myreika.weather.dao.service.owm;

import myreika.weather.domain.Coordinates;
import myreika.weather.dto.alerts.WeatherAlertsDto;

public interface WeatherAlertsDao {

    WeatherAlertsDto getWeatherAlerts(Coordinates coordinates, String units, String lang);
}
