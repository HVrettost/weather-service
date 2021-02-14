package myreika.weather.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GeneralInfoDto {

    private String city;
    private String country;
    private Instant sunrise;
    private Instant sunset;
}
