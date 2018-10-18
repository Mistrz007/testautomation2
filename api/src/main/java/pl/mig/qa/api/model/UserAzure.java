package pl.mig.qa.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserAzure {
    @JsonProperty(value="ID",required = true)
    public int id;
    @JsonProperty(value="UserName",required = true)
    public String userName;
    @JsonProperty(value="Password",required = true)
    public String password;

}
