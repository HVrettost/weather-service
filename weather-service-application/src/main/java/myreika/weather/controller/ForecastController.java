package myreika.weather.controller;

import myreika.weather.api.ForecastApi;
import myreika.weather.domain.Coordinates;
import myreika.weather.dto.forecast.DailyForecastDto;
import myreika.weather.service.ForecastService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForecastController implements ForecastApi {

    private final ForecastService forecastService;

    public ForecastController(ForecastService forecastService) {
        this.forecastService = forecastService;
    }

    @Override
    public ResponseEntity<DailyForecastDto> getDailyForecastByCoordinates(double latitude, double longitude, String units, String lang) {
        Coordinates coordinates = new Coordinates(latitude, longitude);
        DailyForecastDto forecast = forecastService.getDailyForecastByCoordinates(coordinates, units, lang);
        return new ResponseEntity<>(forecast, HttpStatus.OK);
    }
}
