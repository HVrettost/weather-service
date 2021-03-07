package myreika.weather.dto.alerts;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class AlertDto {

    private String senderName;
    private String event;
    private Instant start;
    private Instant end;
    private String description;
}
