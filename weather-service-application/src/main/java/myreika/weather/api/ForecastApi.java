package myreika.weather.api;

import myreika.weather.dto.forecast.DailyForecastDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api/weather/forecast")
public interface ForecastApi {

    @GetMapping(value = "daily/coordinates", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<DailyForecastDto> getDailyForecastByCoordinates(@RequestParam(value = "lat") double latitude,
                                                                   @RequestParam(value = "long") double longitude,
                                                                   @RequestParam(value = "units", required = false) String units,
                                                                   @RequestParam(value = "lang", required = false) String lang);


}
