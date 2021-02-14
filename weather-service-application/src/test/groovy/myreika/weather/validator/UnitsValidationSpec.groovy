package myreika.weather.validator

import myreika.weather.exception.ValidationException
import myreika.weather.exception.error.ValidationError
import spock.lang.Specification
import spock.lang.Unroll

class UnitsValidationSpec extends Specification {

    UnitsValidator unitsValidator

    def setup() {
        unitsValidator = new UnitsValidator()
    }

    @Unroll
    def 'Should throw ValidationException if units value is not within units Enum Set'() {
        when:
            unitsValidator.validate(units)

        then:
            ValidationException validationException = thrown()

        and:
            with(validationException.errorDetails) {
                message == ValidationError.INVALID_UNITS.message
                errorCode == ValidationError.INVALID_UNITS.errorCode
            }

        where:
            units << ['metric1', 'imperials', 'hey']
    }

    @Unroll
    def 'Should not throw exception if units value is within units Enum Set'() {
        when:
            unitsValidator.validate(units)

        then:
            notThrown(ValidationException)

        where:
            units << ['metric', 'standard', 'imperial']
    }

}
