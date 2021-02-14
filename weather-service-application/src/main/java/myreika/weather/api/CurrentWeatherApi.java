package myreika.weather.api;

import myreika.weather.dto.owm.current.CurrentWeatherDto;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api/weather")
public interface CurrentWeatherApi {

    @GetMapping(value = "/current", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CurrentWeatherDto> getCurrentWeatherByCity(@RequestParam(value = "city") String city,
                                                              @RequestParam(value = "units", required = false) String units,
                                                              @RequestParam(value = "lang", required = false) String lang);
}
