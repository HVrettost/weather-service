package myreika.weather.validator;

import myreika.weather.enums.owm.Language;
import myreika.weather.exception.ValidationException;

import myreika.weather.exception.error.ValidationError;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class LanguageValidator implements Validator<String> {

    @Override
    public void validate(String language) {
        if (language == null) {
            return;
        }

        if (Arrays.stream(Language.values()).noneMatch(l -> l.getValue().equals(language))) {
            throw new ValidationException(ValidationError.INVALID_LANGUAGE);
        }
    }
}
