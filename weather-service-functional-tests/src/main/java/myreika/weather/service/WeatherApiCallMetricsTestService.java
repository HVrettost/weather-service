package myreika.weather.service;

import myreika.weather.entity.WeatherApiCallMetrics;
import myreika.weather.repository.WeatherApiCallMetricsTestRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeatherApiCallMetricsTestService {

    private final WeatherApiCallMetricsTestRepository weatherApiCallMetricsTestRepository;

    public WeatherApiCallMetricsTestService(WeatherApiCallMetricsTestRepository weatherApiCallMetricsTestRepository) {
        this.weatherApiCallMetricsTestRepository = weatherApiCallMetricsTestRepository;
    }

    public void deleteAllEntriesByApiCallType(String apiCallType) {
        weatherApiCallMetricsTestRepository.deleteAllByApiCallType(apiCallType);
    }

    public WeatherApiCallMetrics getApiCallMetricsByApiCallType(String apiCallType) {
        return weatherApiCallMetricsTestRepository.findByApiCallType(apiCallType).orElseThrow();
    }
}
