package br.com.cpsoftware.finance.model;

import org.springframework.http.HttpStatusCode;

public class ApiError {
    private String message;
    private HttpStatusCode status;

    public ApiError(HttpStatusCode status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatusCode getStatus() {
        return status;
    }

    public void setStatus(HttpStatusCode status) {
        this.status = status;
    }
}
