package myreika.weather.api;

import myreika.weather.dto.current.CurrentWeatherDto;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api/weather/current")
public interface CurrentWeatherApi {

    @GetMapping(value = "/city/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CurrentWeatherDto> getCurrentWeatherByCity(@PathVariable(value = "name") String city,
                                                              @RequestParam(value = "units", required = false) String units,
                                                              @RequestParam(value = "lang", required = false) String lang);

    @GetMapping(value = "/city-id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CurrentWeatherDto> getCurrentWeatherByCityId(@PathVariable(value = "id") int cityId,
                                                                @RequestParam(value = "units", required = false) String units,
                                                                @RequestParam(value = "lang", required = false) String lang);

    @GetMapping(value = "/coordinates", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CurrentWeatherDto> getCurrentWeatherByCoordinates(@RequestParam(value = "latitude") double latitude,
                                                                     @RequestParam(value = "longitude") double longitude,
                                                                     @RequestParam(value = "units", required = false) String units,
                                                                     @RequestParam(value = "lang", required = false) String lang);

    @GetMapping(value = "/zip-code/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CurrentWeatherDto> getCurrentWeatherByZipCode(@PathVariable(value = "code") int zipCode,
                                                                 @RequestParam(value = "units", required = false) String units,
                                                                 @RequestParam(value = "lang", required = false) String lang);
}
