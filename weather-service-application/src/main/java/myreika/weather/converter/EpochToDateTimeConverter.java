package myreika.weather.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class EpochToDateTimeConverter implements Converter<Integer, Instant> {

    @Override
    public Instant convert(Integer epochTimeInSeconds) {
        return Instant.ofEpochSecond(epochTimeInSeconds);
    }
}
