package myreika.weather.dto.owm.alerts;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Alert {

    @JsonProperty(value = "sender_name")
    private String senderName;
    private String event;
    private int start;
    private int end;
    private String description;

}
