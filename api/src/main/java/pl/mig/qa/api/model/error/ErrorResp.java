package pl.mig.qa.api.model.error;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResp {
    @JsonProperty(value="Error")
    public ErrorBody error;
}
