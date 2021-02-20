package myreika.weather.validator;

import com.google.common.base.Strings;
import myreika.weather.exception.ValidationException;
import myreika.weather.exception.error.ValidationError;
import org.springframework.stereotype.Component;

@Component
public class ZipCodeValidator implements Validator<String> {

    @Override
    public void validate(String zipCode) {
        if (Strings.isNullOrEmpty(zipCode) || !isNumber(zipCode)) {
            throw new ValidationException(ValidationError.INVALID_ZIP_CODE);
        }
    }

    private boolean isNumber(String zipCode) {
        try {
            Integer.parseInt(zipCode);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }
}
