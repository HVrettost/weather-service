package myreika.weather.core.daily

import myreika.weather.actions.UserActions
import myreika.weather.config.WeatherServiceFTSetupSpec

import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Unroll

@SpringBootConfiguration
@SpringBootTest
class DailyForecastSpec extends WeatherServiceFTSetupSpec implements UserActions {

    @Unroll
    def "Should return error message if units passed as parameter is invalid"() {
        when: "a request is made to get the daily forecast"
            def response = getDailyForecast(restTemplate, 37.4641636, 23.4503526, units)

        then: 'error message is returned'
            with (response) {
                errorCode == 1001
                message == 'Invalid units passed as parameter'
            }

        where:
            units << ['imerial', 'petric', 'hello', 'imperia', 'metr', '']
    }

    @Unroll
    def "Should return error message if language passed as parameter is invalid"() {
        when: "a request is made to get the daily forecast"
            def response = getDailyForecast(restTemplate, 37.4641636, 23.4503526, units, language)

        then: 'error message is returned'
            with(response) {
                errorCode == 1002
                message == 'Invalid language passed as parameter'
            }

        where:
            units      | language
            'imperial' | 'qw'
            'metric'   | 'greek'
            null       | 'spa'
            null       | 'ma'
    }

    @Unroll
    def "Should return error message if coordinates passed as parameter are invalid"() {
        when: "a request is made to get the daily forecast"
            def response = getDailyForecast(restTemplate, latitude as Double, longitude as Double)

        then: 'error message is returned'
            with(response) {
                errorCode == 1004
                message == 'Invalid coordinates passed as parameters'
            }

        where:
            latitude | longitude
            200      | 200
            181      | 181
            90       | 200
            12.9890  | -181
            -90.90   | 0
            -90.01   | 181
            90.01    | 95
            90.90    | 18.01
            0        | -180.05
            90       | 180.01
            -91      | 181
    }
}
