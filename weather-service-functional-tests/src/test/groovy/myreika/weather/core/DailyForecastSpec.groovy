package myreika.weather.core

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
                assert status == 409
                with (body) {
                    assert errorCode == 1001
                    assert message == 'Invalid units passed as parameter'
                }
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
                assert status == 409
                with (body) {
                    assert errorCode == 1002
                    assert message == 'Invalid language passed as parameter'
                }
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
                assert status == 409
                with (body) {
                    assert message == 'Invalid coordinates passed as parameters'
                    assert errorCode == 1004
                }
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

    @Unroll
    def "Should return 400 (BAD_REQUEST) if latitude or longitude are empty-null or not numbers"() {
        when: "a request is made to get the daily forecast"
            def response = getDailyForecast(restTemplate, latitude, longitude)

        then: 'error message is returned'
            assert response.status == 400
            assert response.body == null

        where:
            latitude | longitude
            null     | null
            80.30980 | null
            null     | 89.909899
            "lat"    | "lon"
            "lat"    | null
            null     | "lon"
            80.980   | "lon"
            "lat"    | 87.9800
    }

    @Unroll
    def "Should return successful response (200 OK) if latitude, longitude, units and language have valid values"() {
        when: "a request is made to get the daily forecast"
            def response = getDailyForecast(restTemplate, latitude, longitude, units, language)

        then: 'successful response is returned'
            with (response) {
                assert response.status == 200
                with (body) {
                    assert it["latitude"] == 37.9718
                    assert it["longitude"] == 23.7371
                    assert it["timezone"] == "Europe/Athens"
                    assert it["timezoneOffsetInSeconds"] == 7200
                    assert it["daily"].size() == 8
                }
            }

        where:
            latitude | longitude | units      | language
            -90      | -180      | "metric"   | "en"
            90       | 180       | "imperial" | "es"
            -90      | 180       | "metric"   | null
            90       | -180      | null       | "fr"
            89.907   | -179      | null       | null
            58.678   | 120.8909  | "metric"   | "pl"
    }

    @Unroll
    def "Should return error response third party service (OWM) throws exception because it could not find coordinates"() {
        when: "a request is made to get the daily forecast"
            def response = getDailyForecast(restTemplate, -57.908789, 89.909899)

        then: 'error response is returned'
            with(response) {
                assert status == 409
                with (body) {
                    assert message == 'geographical coordinates not found'
                    assert errorCode == 2000
                }
            }
    }
}
