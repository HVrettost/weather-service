package myreika.weather.actions

import myreika.weather.request.DailyForecastRequest
import org.springframework.boot.test.web.client.TestRestTemplate

trait UserActions {

    def getDailyForecast(TestRestTemplate restTemplate, double latitude, double longitude, String units = null, String language = null) {
        DailyForecastRequest request = new DailyForecastRequest(restTemplate, latitude, longitude, units, language)
        request.getDailyForecast()
    }
}