package myreika.weather.controller;

import myreika.weather.api.CurrentWeatherApi;
import myreika.weather.dto.openweathermap.current.CurrentWeather;
import myreika.weather.service.CurrentWeatherService;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrentWeatherController implements CurrentWeatherApi {

    CurrentWeatherService currentWeatherService;

    public CurrentWeatherController(CurrentWeatherService currentWeatherService) {
        this.currentWeatherService = currentWeatherService;
    }

    @Override
    public CurrentWeather getCurrentWeatherByCity(String city) {
        return currentWeatherService.getCurrentWeatherByCity(city);
    }
}
