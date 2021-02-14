package myreika.weather.validator;

import com.google.common.base.Strings;
import myreika.weather.exception.ValidationException;
import myreika.weather.exception.error.ValidationError;
import org.springframework.stereotype.Component;

@Component
public class CityValidator implements Validator<String> {

    private static final int CITY_MAXIMUM_LENGTH = 25;

    @Override
    public void validate(String city) {
        if (Strings.isNullOrEmpty(city) || city.length() > CITY_MAXIMUM_LENGTH) {
            throw new ValidationException(ValidationError.INVALID_CITY_NAME);
        }
    }
}
