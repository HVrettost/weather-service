package myreika.weather.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "myreika.weather.owm")
@PropertySource("classpath:owm.properties")
@Getter
@Setter
public class OwmConfig {

    private String apiKey;
    private String currentWeatherUrl;
}
