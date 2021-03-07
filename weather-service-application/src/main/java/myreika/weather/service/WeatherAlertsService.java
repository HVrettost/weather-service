package myreika.weather.service;

import myreika.weather.domain.Coordinates;
import myreika.weather.dto.alerts.WeatherAlertsDto;

public interface WeatherAlertsService {

    WeatherAlertsDto getWeatherAlerts(Coordinates coordinates, String units, String lang);
}
