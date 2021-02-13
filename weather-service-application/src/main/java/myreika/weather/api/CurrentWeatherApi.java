package myreika.weather.api;

import myreika.weather.dto.openweathermap.current.CurrentWeather;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api/weather")
public interface CurrentWeatherApi {

    @GetMapping(value = "/current", produces = MediaType.APPLICATION_JSON_VALUE)
    CurrentWeather getCurrentWeatherByCity(@RequestParam("city") String city);
}
