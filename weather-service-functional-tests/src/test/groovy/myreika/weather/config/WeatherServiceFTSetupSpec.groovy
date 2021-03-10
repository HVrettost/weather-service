package myreika.weather.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.test.web.client.TestRestTemplate
import spock.lang.Shared
import spock.lang.Specification

class WeatherServiceFTSetupSpec extends Specification {

    @Shared
    TestRestTemplate restTemplate

    @Shared
    ObjectMapper objectMapper

    def setupSpec() {
        restTemplate = new TestRestTemplate()
        objectMapper = new ObjectMapper()
    }
}
