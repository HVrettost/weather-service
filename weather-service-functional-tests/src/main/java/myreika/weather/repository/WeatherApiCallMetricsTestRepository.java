package myreika.weather.repository;

import myreika.weather.entity.WeatherApiCallMetrics;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeatherApiCallMetricsTestRepository extends MongoRepository<WeatherApiCallMetrics, ObjectId> {

    void deleteAllByApiCallType(@Param("apiCallType") String apiCallType);

    Optional<WeatherApiCallMetrics> findByApiCallType(@Param("apiCallType") String apiCallType);
}
