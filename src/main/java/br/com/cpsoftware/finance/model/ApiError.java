package br.com.cpsoftware.finance.model;

import org.springframework.http.HttpStatusCode;
import lombok.Data;

@Data
public class ApiError {
    private String message;
    private HttpStatusCode status;

    public ApiError(HttpStatusCode status, String message) {
        this.status = status;
        this.message = message;
    }

}
