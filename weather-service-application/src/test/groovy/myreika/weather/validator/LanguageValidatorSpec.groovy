package myreika.weather.validator

import myreika.weather.exception.ValidationException
import myreika.weather.exception.error.ValidationError
import spock.lang.Specification
import spock.lang.Unroll

class LanguageValidatorSpec extends Specification {

    LanguageValidator languageValidator

    def setup() {
        languageValidator = new LanguageValidator()
    }

    @Unroll
    def 'Should throw ValidationException if does not exist in language EnumSet'() {
        when:
            languageValidator.validate(language)

        then:
            ValidationException exception = thrown()

        and:
            with(exception.errorDetails) {
                message == ValidationError.INVALID_LANGUAGE.message
                errorCode == ValidationError.INVALID_LANGUAGE.errorCode
            }

        where:
            language << ['hel', 'greek', 'hebrew', 'esp']
    }

    @Unroll
    def 'Should pass validations if language value is within language Enum Set'() {
        when:
            languageValidator.validate(language)

        then:
            notThrown(ValidationException)

        where:
            language << ['el', 'es', 'en', 'fa']
    }
}
