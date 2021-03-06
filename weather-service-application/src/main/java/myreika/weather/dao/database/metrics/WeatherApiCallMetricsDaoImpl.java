package myreika.weather.dao.database.metrics;

import myreika.weather.domain.enums.metrics.ApiCallType;
import myreika.weather.entity.WeatherApiCallMetrics;
import myreika.weather.repository.WeatherApiCallMetricsRepository;
import org.springframework.stereotype.Component;

@Component
public class WeatherApiCallMetricsDaoImpl implements WeatherApiCallMetricsDao {

    private final WeatherApiCallMetricsRepository weatherApiCallMetricsRepository;

    public WeatherApiCallMetricsDaoImpl(WeatherApiCallMetricsRepository weatherApiCallMetricsRepository) {
        this.weatherApiCallMetricsRepository = weatherApiCallMetricsRepository;
    }

    @Override
    public void saveApiCallMetric(ApiCallType apiCallType) {
        WeatherApiCallMetrics metric = weatherApiCallMetricsRepository.findByApiCallType(apiCallType)
                .orElse(createDefaultApiCallMetrics(apiCallType));
        if (metric.getId() != null) {
            metric.setTotalTimesCalled(metric.getTotalTimesCalled() + 1);
        }

        weatherApiCallMetricsRepository.save(metric);
    }

    private WeatherApiCallMetrics createDefaultApiCallMetrics(ApiCallType apiCallType) {
        return new WeatherApiCallMetrics(null, apiCallType, 1);
    }
}
