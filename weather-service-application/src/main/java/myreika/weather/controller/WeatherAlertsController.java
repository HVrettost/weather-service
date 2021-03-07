package myreika.weather.controller;

import myreika.weather.api.WeatherAlertsApi;
import myreika.weather.domain.Coordinates;
import myreika.weather.dto.alerts.WeatherAlertsDto;
import myreika.weather.service.WeatherAlertsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherAlertsController implements WeatherAlertsApi {


    private final WeatherAlertsService weatherAlertsService;

    public WeatherAlertsController(WeatherAlertsService weatherAlertsService) {
        this.weatherAlertsService = weatherAlertsService;
    }

    @Override
    public ResponseEntity<WeatherAlertsDto> getWeatherAlerts(double latitude, double longitude, String units, String lang) {
        Coordinates coordinates = new Coordinates(latitude, longitude);
        WeatherAlertsDto alerts = weatherAlertsService.getWeatherAlerts(coordinates, units, lang);
        return new ResponseEntity<>(alerts, HttpStatus.OK);
    }
}
