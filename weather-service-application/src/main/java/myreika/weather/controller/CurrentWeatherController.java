package myreika.weather.controller;

import myreika.weather.api.CurrentWeatherApi;
import myreika.weather.domain.Coordinates;
import myreika.weather.dto.current.CurrentWeatherDto;
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
        CurrentWeatherDto currentWeatherDto =  currentWeatherService.getCurrentWeatherByCity(city, units, lang);
        return new ResponseEntity<>(currentWeatherDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CurrentWeatherDto> getCurrentWeatherByCityId(int cityId, String units, String lang) {
        CurrentWeatherDto currentWeatherDto = currentWeatherService.getCurrentWeatherByCityId(cityId, units, lang);
        return new ResponseEntity<>(currentWeatherDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CurrentWeatherDto> getCurrentWeatherByCoordinates(double latitude, double longitude, String units, String lang) {
        Coordinates coordinates = new Coordinates(latitude, longitude);
        CurrentWeatherDto currentWeatherDto = currentWeatherService.getCurrentWeatherByCoordinates(coordinates, units, lang);
        return new ResponseEntity<>(currentWeatherDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CurrentWeatherDto> getCurrentWeatherByZipCode(int zipCode, String units, String lang) {
        CurrentWeatherDto currentWeatherDto = currentWeatherService.getCurrentWeatherByZipCode(zipCode, units, lang);
        return new ResponseEntity<>(currentWeatherDto, HttpStatus.OK);
    }
}
