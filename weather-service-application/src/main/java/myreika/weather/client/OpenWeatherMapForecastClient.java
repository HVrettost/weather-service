package myreika.weather.client;

import myreika.weather.dto.owm.forecast.daily.DailyForecast;

public interface OpenWeatherMapForecastClient {

    DailyForecast getDailyForecastByCoordinates(double latitude, double longitude, String units, String lang);
}
