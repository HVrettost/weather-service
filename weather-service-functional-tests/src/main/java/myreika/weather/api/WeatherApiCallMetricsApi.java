package myreika.weather.api;

import myreika.weather.entity.WeatherApiCallMetrics;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Profile("local-dev")
@RequestMapping("/api/test/api-call-metrics")
public interface WeatherApiCallMetricsApi {

    @DeleteMapping(value = "/{apiCallType}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> deleteApiCallMetricsByApiCallType(@PathVariable(value = "apiCallType") String  apiCallType);

    @GetMapping(value = "/{apiCallType}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<WeatherApiCallMetrics> getApiCallMetricsByApiCallType(@PathVariable(value = "apiCallType") String apiCallType);
}
