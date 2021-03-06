package myreika.weather.dto.metrics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import myreika.weather.domain.enums.metrics.ApiCallType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherApiCallMetricsDto {

    private String id;
    private ApiCallType apiCallType;
    private long totalTimesCalled;
}
