package myreika.weather.validator;

import myreika.weather.exception.ValidationException;
import myreika.weather.exception.error.ValidationError;
import org.springframework.stereotype.Component;

@Component
public class CityIdValidator implements Validator<Integer> {

    private static final int CITY_ID_MAXIMUM_LENGTH = 10;

    @Override
    public void validate(Integer cityId) {
        if (String.valueOf(cityId).length() > CITY_ID_MAXIMUM_LENGTH) {
            throw new ValidationException(ValidationError.INVALID_CITY_ID);
        }
    }
}
