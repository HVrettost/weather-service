package myreika.weather.controller;

import myreika.weather.api.ForecastApi;
import myreika.weather.domain.Coordinates;
import myreika.weather.dto.forecast.daily.DailyForecastDto;
import myreika.weather.dto.forecast.hourly.HourlyForecastDto;
import myreika.weather.dto.forecast.minutely.MinutelyForecastDto;
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

    @Override
    public ResponseEntity<HourlyForecastDto> getHourlyForecastByCoordinates(double latitude, double longitude, String units, String lang) {
        Coordinates coordinates = new Coordinates(latitude, longitude);
        HourlyForecastDto forecast = forecastService.getHourlyForecastByCoordinates(coordinates, units, lang);
        return new ResponseEntity<>(forecast, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<MinutelyForecastDto> getMinutelyForecastByCoordinates(double latitude, double longitude, String units, String lang) {
        Coordinates coordinates = new Coordinates(latitude, longitude);
        MinutelyForecastDto forecast = forecastService.getMinutelyForecastByCoordinates(coordinates, units, lang);
        return new ResponseEntity<>(forecast, HttpStatus.OK);
    }
}
