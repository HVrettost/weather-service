package myreika.weather.actions

import myreika.weather.request.DailyForecastRequest
import myreika.weather.request.HourlyForecastRequest
import myreika.weather.request.MinutelyForecastRequest
import myreika.weather.request.WeatherAlertsRequest
import org.springframework.boot.test.web.client.TestRestTemplate

trait UserActions {

    def getDailyForecast(TestRestTemplate restTemplate, def latitude, def longitude, def units = null, def language = null) {
        DailyForecastRequest request = new DailyForecastRequest(restTemplate, latitude, longitude, units, language)
        request.getDailyForecast()
    }

    def getHourlyForecast(TestRestTemplate restTemplate, def latitude, def longitude, def units = null, def language = null) {
        HourlyForecastRequest request = new HourlyForecastRequest(restTemplate, latitude, longitude, units, language)
        request.getHourlyForecast()
    }

    def getMinutelyForecast(TestRestTemplate restTemplate, def latitude, def longitude, def units = null, def language = null) {
        MinutelyForecastRequest request = new MinutelyForecastRequest(restTemplate, latitude, longitude, units, language)
        request.getMinutelyForecast()
    }

    def getWeatherAlerts(TestRestTemplate restTemplate, def latitude, def longitude, def units = null, def language = null) {
        WeatherAlertsRequest request = new WeatherAlertsRequest(restTemplate, latitude, longitude, units, language)
        request.getWeatherAlerts()
    }
}