package pl.mig.qa.api.specyfications;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pl.mig.qa.api.configuration.Configuration;

public class Specifications {


    public static RequestSpecification requestSpecBuilder(){
        return new RequestSpecBuilder()
//                    .addHeader()
                    .setBaseUri(Configuration.URL)
                    .setContentType(ContentType.JSON)
                    .setBasePath("v2/")
                .build();
    }
}
