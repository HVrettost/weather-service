package myreika.weather.entity;

import lombok.Getter;
import lombok.Setter;
import myreika.weather.domain.enums.metrics.ApiCallType;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document("weather_api_call_metrics")
public class WeatherApiCallMetrics {

    @Id
    @Field("_id")
    private ObjectId id;

    @Field("api_call_type")
    private ApiCallType apiCallType;

    @Field("total_times_called")
    private long totalTimesCalled;
}
