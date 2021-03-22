package myreika.weather.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "myreika.weather.cors")
@PropertySource("classpath:${spring.profiles.active}/cors-${spring.profiles.active}.properties")
@Getter
@Setter
public class CorsConfig {

    private List<String> allowedOrigins;
    private List<String> allowedMethods;
    private String pathPattern;
}
