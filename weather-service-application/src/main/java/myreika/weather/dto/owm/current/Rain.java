package myreika.weather.dto.owm.current;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rain {

    @JsonProperty(value = "1h")
    private double rainVolumeLastOneHourInMillimetres;

    @JsonProperty(value = "3h")
    private double rainVolumeLastThreeHoursInMillimetres;
}
