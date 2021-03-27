package myreika.weather.actions.user

import myreika.weather.request.forecast.DailyForecastRequest
import myreika.weather.request.forecast.HourlyForecastRequest
import myreika.weather.request.forecast.MinutelyForecastRequest
import org.springframework.boot.test.web.client.TestRestTemplate

trait ForecastUserActions {

    def getDailyForecast(TestRestTemplate restTemplate, def latitude, def longitude, def units = null, def language = null) {
        DailyForecastRequest request = new DailyForecastRequest(restTemplate, latitude, longitude, units, language)
        request.executeRequest()
    }

    def getHourlyForecast(TestRestTemplate restTemplate, def latitude, def longitude, def units = null, def language = null) {
        HourlyForecastRequest request = new HourlyForecastRequest(restTemplate, latitude, longitude, units, language)
        request.executeRequest()
    }

    def getMinutelyForecast(TestRestTemplate restTemplate, def latitude, def longitude, def units = null, def language = null) {
        MinutelyForecastRequest request = new MinutelyForecastRequest(restTemplate, latitude, longitude, units, language)
        request.executeRequest()
    }
}