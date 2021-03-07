package myreika.weather.client;

import myreika.weather.dto.owm.forecast.daily.DailyForecast;
import myreika.weather.dto.owm.forecast.hourly.HourlyForecast;
import myreika.weather.dto.owm.forecast.minutely.MinutelyForecast;

public interface OpenWeatherMapForecastClient {

    DailyForecast getDailyForecastByCoordinates(double latitude, double longitude, String units, String lang);

    HourlyForecast getHourlyForecastByCoordinates(double latitude, double longitude, String units, String lang);

    MinutelyForecast getMinutelyForecastByCoordinates(double latitude, double longitude, String units, String lang);
}
