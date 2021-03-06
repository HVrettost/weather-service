package myreika.weather.dao.database.metrics;

import myreika.weather.domain.enums.metrics.ApiCallType;

public interface WeatherApiCallMetricsDao {

    void saveApiCallMetric(ApiCallType apiCallType);
}
