package myreika.weather.validator;

import com.google.common.base.Strings;
import myreika.weather.exception.ValidationException;
import myreika.weather.exception.error.ValidationError;
import org.springframework.stereotype.Component;

@Component
public class CityIdValidator implements Validator<String> {

    private static final int CITY_ID_MAXIMUM_LENGTH = 10;

    @Override
    public void validate(String cityId) {
        if (Strings.isNullOrEmpty(cityId) || !isNumber(cityId) || cityId.length() > CITY_ID_MAXIMUM_LENGTH) {
            throw new ValidationException(ValidationError.INVALID_CITY_ID);
        }
    }

    private boolean isNumber(String cityId) {
        try {
            Integer.parseInt(cityId);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }
}
