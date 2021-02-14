package myreika.weather.exception.handler;

import myreika.weather.exception.OwmException;
import myreika.weather.exception.error.OwmClientError;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

@Component
public class OwmExceptionHandler {

    public void handleOwmException(HttpClientErrorException exception) {
        if (exception.getStatusCode() == HttpStatus.NOT_FOUND) {
            throw new OwmException(OwmClientError.RESOURCE_NOT_FOUND);
        } else if (exception.getStatusCode() == HttpStatus.UNAUTHORIZED) {
            throw new OwmException(OwmClientError.INVALID_API_KEY);
        } else {
            throw new OwmException(OwmClientError.OWM_GENERAL_ERROR);
        }
    }
}
