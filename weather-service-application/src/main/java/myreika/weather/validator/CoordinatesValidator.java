package myreika.weather.validator;

import myreika.weather.dto.CoordinatesDto;
import myreika.weather.exception.ValidationException;
import myreika.weather.exception.error.ValidationError;
import org.springframework.stereotype.Component;

@Component
public class CoordinatesValidator implements Validator<CoordinatesDto> {

    private static final double LATITUDE_MIN_VALUE = -90;
    private static final double LATITUDE_MAX_VALUE = 90;
    private static final double LONGITUDE_MIN_VALUE = -180;
    private static final double LONGITUDE_MAX_VALUE = 180;


    @Override
    public void validate(CoordinatesDto coordinatesDto) {
        if (coordinatesDto == null || !isValidLatitude(coordinatesDto.getLatitude()) || !isValidLongitude(coordinatesDto.getLongitude())) {
            throw new ValidationException(ValidationError.INVALID_COORDINATES);
        }
    }

    private boolean isValidLatitude(double latitude) {
        return latitude > LATITUDE_MIN_VALUE && latitude < LATITUDE_MAX_VALUE;
    }

    private boolean isValidLongitude(double longitude) {
        return longitude > LONGITUDE_MIN_VALUE && longitude  < LONGITUDE_MAX_VALUE;
    }
}
