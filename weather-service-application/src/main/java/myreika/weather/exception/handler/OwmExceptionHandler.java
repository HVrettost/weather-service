package myreika.weather.exception.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import myreika.weather.exception.OwmException;
import myreika.weather.exception.dto.OwmErrorResponse;
import myreika.weather.exception.error.OwmClientError;

import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

@Component
public class OwmExceptionHandler {

    private final ObjectMapper objectMapper;

    public OwmExceptionHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void handleOwmException(HttpClientErrorException exception) {
        OwmClientError error = OwmClientError.OWM_ERROR;
        OwmErrorResponse errorResponse = deserialize(exception);
        error.setMessage(errorResponse.getMessage());
        error.setDescription(errorResponse.getMessage());

        throw new OwmException(error);
    }

    private OwmErrorResponse deserialize(HttpClientErrorException exception) {
        try {
            return objectMapper.readValue(exception.getResponseBodyAsString(), OwmErrorResponse.class);
        } catch (Exception ex) {
            return new OwmErrorResponse();
        }
    }
}
