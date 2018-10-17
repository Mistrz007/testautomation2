package pl.mig.qa.api.model.error;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorBody {
    @JsonProperty(value="error.code")
    public int code;
    @JsonProperty(value="validation_erro")
    public String validationError;
    @JsonProperty(value="message")
    public String message;

    @Override
    public String toString() {
        return "ErrorBody{" +
                "code='" + code + '\'' +
                ", error='" + validationError + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
