package myreika.weather.validator;

import myreika.weather.enums.owm.Units;
import myreika.weather.exception.ValidationException;
import myreika.weather.exception.error.ValidationError;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class UnitsValidator implements Validator<String> {

    @Override
    public void validate(String units) {
        if (!Stream.of(Units.values()).anyMatch(u -> u.getValue().equals(units)))
            throw new ValidationException(ValidationError.INVALID_UNITS);
    }
}
