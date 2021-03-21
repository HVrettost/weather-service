package myreika.weather.actions

import myreika.weather.request.alerts.WeatherAlertsRequest
import org.springframework.boot.test.web.client.TestRestTemplate

trait AlertsUserActions {

    def getWeatherAlerts(TestRestTemplate restTemplate, def latitude, def longitude, def units = null, def language = null) {
        WeatherAlertsRequest request = new WeatherAlertsRequest(restTemplate, latitude, longitude, units, language)
        request.executeRequest()
    }
}