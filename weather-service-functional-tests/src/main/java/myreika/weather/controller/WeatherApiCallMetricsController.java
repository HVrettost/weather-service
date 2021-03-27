package myreika.weather.controller;

import myreika.weather.entity.WeatherApiCallMetrics;
import myreika.weather.service.WeatherApiCallMetricsTestService;
import myreika.weather.api.WeatherApiCallMetricsApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherApiCallMetricsController implements WeatherApiCallMetricsApi {

    private final WeatherApiCallMetricsTestService weatherApiCallMetricsTestService;

    public WeatherApiCallMetricsController(WeatherApiCallMetricsTestService weatherApiCallMetricsTestService) {
        this.weatherApiCallMetricsTestService = weatherApiCallMetricsTestService;
    }

    @Override
    public ResponseEntity<Void> deleteApiCallMetricsByApiCallType(String apiCallType) {
        weatherApiCallMetricsTestService.deleteAllEntriesByApiCallType(apiCallType);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<WeatherApiCallMetrics> getApiCallMetricsByApiCallType(String apiCallType) {
        WeatherApiCallMetrics metrics = weatherApiCallMetricsTestService.getApiCallMetricsByApiCallType(apiCallType);
        return new ResponseEntity<>(metrics, HttpStatus.OK);
    }
}
