package myreika.weather.service;

import myreika.weather.dao.database.metrics.WeatherApiCallMetricsDao;
import myreika.weather.dao.service.owm.ForecastDao;
import myreika.weather.domain.Coordinates;
import myreika.weather.domain.enums.metrics.ApiCallType;
import myreika.weather.dto.forecast.daily.DailyForecastDto;
import myreika.weather.dto.forecast.hourly.HourlyForecastDto;
import myreika.weather.dto.forecast.minutely.MinutelyForecastDto;
import myreika.weather.validator.CoordinatesValidator;
import myreika.weather.validator.LanguageValidator;
import myreika.weather.validator.UnitsValidator;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ForecastServiceImpl implements ForecastService {

    private final ForecastDao forecastDao;
    private final UnitsValidator unitsValidator;
    private final LanguageValidator languageValidator;
    private final CoordinatesValidator coordinatesValidator;
    private final WeatherApiCallMetricsDao weatherApiCallMetricsDao;

    public ForecastServiceImpl(ForecastDao forecastDao,
                               UnitsValidator unitsValidator,
                               LanguageValidator languageValidator,
                               CoordinatesValidator coordinatesValidator,
                               WeatherApiCallMetricsDao weatherApiCallMetricsDao) {
        this.forecastDao = forecastDao;
        this.unitsValidator = unitsValidator;
        this.languageValidator = languageValidator;
        this.coordinatesValidator = coordinatesValidator;
        this.weatherApiCallMetricsDao = weatherApiCallMetricsDao;
    }

    @Override
    @Transactional
    public DailyForecastDto getDailyForecastByCoordinates(Coordinates coordinates, String units, String lang) {
        validateParameters(coordinates, units, lang);
        weatherApiCallMetricsDao.saveApiCallMetric(ApiCallType.DAILY_FORECAST);

        return forecastDao.getDailyForecastByCoordinates(coordinates, units, lang);
    }

    @Override
    @Transactional
    public HourlyForecastDto getHourlyForecastByCoordinates(Coordinates coordinates, String units, String lang) {
        validateParameters(coordinates, units, lang);
        weatherApiCallMetricsDao.saveApiCallMetric(ApiCallType.HOURLY_FORECAST);

        return forecastDao.getHourlyForecastByCoordinates(coordinates, units, lang);
    }

    @Override
    @Transactional
    public MinutelyForecastDto getMinutelyForecastByCoordinates(Coordinates coordinates, String units, String lang) {
        validateParameters(coordinates, units, lang);
        weatherApiCallMetricsDao.saveApiCallMetric(ApiCallType.MINUTELY_FORECAST);

        return forecastDao.getMinutelyForecastByCoordinates(coordinates, units, lang);
    }

    private void validateParameters(Coordinates coordinates, String units, String lang) {
        unitsValidator.validate(units);
        languageValidator.validate(lang);
        coordinatesValidator.validate(coordinates);
    }
}
