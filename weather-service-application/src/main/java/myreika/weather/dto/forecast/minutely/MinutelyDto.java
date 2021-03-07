package myreika.weather.dto.forecast.minutely;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class MinutelyDto {

    private Instant dateTime;
    private int precipitation;
}
