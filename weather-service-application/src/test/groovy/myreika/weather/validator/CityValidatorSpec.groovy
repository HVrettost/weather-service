package myreika.weather.validator

import myreika.weather.exception.ValidationException
import myreika.weather.exception.error.ValidationError
import spock.lang.Specification
import spock.lang.Unroll

class CityValidatorSpec extends Specification {

    CityValidator cityValidator

    def setup() {
        cityValidator = new CityValidator()
    }

    @Unroll
    def 'Should throw ValidationException if city is null or empty'() {
        when:
            cityValidator.validate(city)

        then:
            ValidationException validationException = thrown()

        and:
            with (validationException.errorDetails) {
                message == ValidationError.INVALID_CITY_NAME.message
                errorCode == ValidationError.INVALID_CITY_NAME.errorCode
            }

        where:
            city << ['', null]
    }

    @Unroll
    def 'Should throw ValidationException if city letters length exceed 25'() {
        when:
            cityValidator.validate(city)

        then:
            ValidationException validationException = thrown()

        and:
            with (validationException.errorDetails) {
                message == ValidationError.INVALID_CITY_NAME.message
                errorCode == ValidationError.INVALID_CITY_NAME.errorCode
            }

        where:
            city << ['abcdefghijklmnopqrstuvwxyzabcdefgasasdsdsdasdasd',
                     'aaaaaaaaaaaaaaaaaaaaaaaaaa']
    }

    @Unroll
    def 'Should pass validation if city is not null or empth and within 1 and 25 letters'() {
        when:
            cityValidator.validate(city)

        then:
            notThrown(ValidationException)

        where:
            city << ['Athens', 'Moscow', 'aaaaaaaaaaaaaaaaaaaaaaaa', 'a']
    }
}
