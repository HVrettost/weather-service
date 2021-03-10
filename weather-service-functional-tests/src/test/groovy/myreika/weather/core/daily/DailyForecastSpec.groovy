package myreika.weather.core.daily

import myreika.weather.config.WeatherServiceFTSetupSpec
import myreika.weather.dto.ErrorDetails

import myreika.weather.request.DailyForecastRequest

import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.web.client.HttpClientErrorException
import spock.lang.Unroll

@SpringBootConfiguration
@SpringBootTest
class DailyForecastSpec extends WeatherServiceFTSetupSpec {

    @Unroll
    def "Should throw exception if units passed as parameter is invalid"() {
        given: "a daily forecast request is created"
            DailyForecastRequest request = new DailyForecastRequest(restTemplate, 37.4641636, 23.4503526, units)

        when: "the exposed daily forecast endpoint is called"
            request.getDailyForecast()

        then: 'exception is thrown'
            HttpClientErrorException ex = thrown()
            ex.statusCode == HttpStatus.CONFLICT
            with(objectMapper.readValue(ex.responseBodyAsString, ErrorDetails)) {
                errorCode == 1001
                message == 'Invalid units passed as parameter'
            }

        where:
            units << ['imerial', 'petric', 'hello', 'imperia', 'metr', '']
    }

    @Unroll
    def "Should throw exception if language passed as parameter is invalid"() {
        given: "a daily forecast request is created"
            DailyForecastRequest request = new DailyForecastRequest(restTemplate, 37.4641636, 23.4503526, units, language)

        when: "the exposed daily forecast endpoint is called"
            request.getDailyForecast()

        then: 'exception is thrown'
            HttpClientErrorException ex = thrown()
            ex.statusCode == HttpStatus.CONFLICT
            with(objectMapper.readValue(ex.responseBodyAsString, ErrorDetails)) {
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


}
