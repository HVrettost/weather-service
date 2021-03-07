package myreika.weather.api;

import myreika.weather.dto.alerts.WeatherAlertsDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api/weather/alerts")
public interface WeatherAlertsApi {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<WeatherAlertsDto> getWeatherAlerts(@RequestParam(value = "lat") double latitude,
                                                      @RequestParam(value = "lon") double longitude,
                                                      @RequestParam(value = "units", required = false) String units,
                                                      @RequestParam(value = "lang", required = false) String lang);
}
