package myreika.weather.repository;

import myreika.weather.domain.enums.metrics.ApiCallType;
import myreika.weather.entity.WeatherApiCallMetrics;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeatherApiCallMetricsRepository extends MongoRepository<WeatherApiCallMetrics, ObjectId> {

    Optional<WeatherApiCallMetrics> findByApiCallType(@Param("apiCallType") ApiCallType apiCallType);
}
