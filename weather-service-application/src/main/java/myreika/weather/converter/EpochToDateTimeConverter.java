package myreika.weather.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class EpochToDateTimeConverter implements Converter<Integer, Instant> {

    @Override
    public Instant convert(@NonNull Integer epochTimeInSeconds) {
        return Instant.ofEpochSecond(epochTimeInSeconds);
    }
}
