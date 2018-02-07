package spittr.api.error;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

public class ApiError {

    @Setter
    @Getter
    private HttpStatus httpStatus;
    @Setter
    @Getter
    private String errorMessage;

    public ApiError(HttpStatus httpStatus, String errorMessage) {
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }
}
