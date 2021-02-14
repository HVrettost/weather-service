package myreika.weather.controller;

import myreika.weather.api.CurrentWeatherApi;
import myreika.weather.dto.owm.current.CurrentWeatherDto;
import myreika.weather.service.CurrentWeatherService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrentWeatherController implements CurrentWeatherApi {

    CurrentWeatherService currentWeatherService;

    public CurrentWeatherController(CurrentWeatherService currentWeatherService) {
        this.currentWeatherService = currentWeatherService;
    }

    @Override
    public ResponseEntity<CurrentWeatherDto> getCurrentWeatherByCity(String city, String units, String lang) {
        CurrentWeatherDto currentWeather =  currentWeatherService.getCurrentWeatherByCity(city, units, lang);
        return new ResponseEntity<>(currentWeather, HttpStatus.OK);
    }
}
