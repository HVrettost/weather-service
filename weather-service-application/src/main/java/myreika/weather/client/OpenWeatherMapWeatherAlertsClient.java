package myreika.weather.client;

import myreika.weather.dto.owm.alerts.WeatherAlerts;

public interface OpenWeatherMapWeatherAlertsClient {

    WeatherAlerts getWeatherAlerts(double latitude, double longitude, String units, String lang);
}
