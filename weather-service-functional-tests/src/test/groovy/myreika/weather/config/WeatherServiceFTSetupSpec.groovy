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

    @Shared
    myreika.weather.actor.UserActor userActor

    @Shared
    myreika.weather.actor.SystemActor systemActor

    def setupSpec() {
        restTemplate = new TestRestTemplate()
        objectMapper = new ObjectMapper()
        userActor = new myreika.weather.actor.UserActor()
        systemActor = new myreika.weather.actor.SystemActor()
    }
}
