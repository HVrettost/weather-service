package myreika.weather.core.alerts

import myreika.weather.config.WeatherServiceFTSetupSpec
import myreika.weather.domain.enums.metrics.ApiCallType
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Unroll

@SpringBootConfiguration
@SpringBootTest
class WeatherAlertsSpec extends WeatherServiceFTSetupSpec {

    def cleanup() {
        systemActor.deleteApiCallMetricsByApiCallType(restTemplate, ApiCallType.WEATHER_ALERTS)
    }

    @Unroll
    def "Should return error message if units passed as parameter is invalid"() {
        when: "a request is made to get the weather alerts for certain coordinates"
            def response = userActor.getWeatherAlerts(restTemplate, 37.4641636, 23.4503526, units)

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
        when: "a request is made to get the weather alerts for certain coordinates"
            def response = userActor.getWeatherAlerts(restTemplate, 37.4641636, 23.4503526, units, language)

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
        when: "a request is made to get the weather alerts for certain coordinates"
            def response = userActor.getWeatherAlerts(restTemplate, latitude as Double, longitude as Double)

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
        when: "a request is made to get weather alerts for certain coordinates"
            def response = userActor.getWeatherAlerts(restTemplate, latitude, longitude)

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
        when: "a request is made to get the weather alerts for certain coordinates"
            def response = userActor.getWeatherAlerts(restTemplate, latitude, longitude, units, language)

        then: 'successful response is returned'
            with (response) {
                assert response.status == 200
                with (body) {
                    assert it["latitude"] == 55.7558
                    assert it["longitude"] == 37.6173
                    assert it["timezone"] == "Europe/Moscow"
                    assert it["timezoneOffsetInSeconds"] == 10800
                    assert it["alerts"].size() == 6
                }
            }

        and: 'entry for api call metric should be persisted in database'
            with (systemActor.getApiCallMetricsByApiCallType(restTemplate, ApiCallType.WEATHER_ALERTS).body) {
                assert totalTimesCalled == 1
                assert apiCallType == ApiCallType.WEATHER_ALERTS.name()
            }

        where:
            latitude | longitude | units      | language
            -90      | -180      | "metric"   | "bg"
            90       | 180       | "imperial" | "da"
            -90      | 180       | "metric"   | null
            90       | -180      | null       | "de"
            89.907   | -179      | null       | null
            58.678   | 120.8909  | "metric"   | "al"
    }

    @Unroll
    def "Should return error response third party service (OWM) throws exception because number of api calls were exceeded"() {
        when: "a request is made to get the minutely forecast"
            def response = userActor.getWeatherAlerts(restTemplate, -70.90, 150.90)

        then: 'error response is returned'
            with(response) {
                assert status == 409
                with (body) {
                    assert message == 'number of api calls exceeded'
                    assert errorCode == 2000
                }
            }
    }
}
