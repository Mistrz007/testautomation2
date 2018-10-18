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

    public static RequestSpecification requestSpecBuilderAPIKEY(){
        return new RequestSpecBuilder()
                .addHeader("Authorise","Apikey, kalsdkjlkasjdalsdjljlk")
                .setBaseUri(Configuration.URL)
                .setContentType(ContentType.JSON)
                .setBasePath("v2/")
                .build();
    }

    public static RequestSpecification requestSpecBuilderUserAzure(){
        return new RequestSpecBuilder()
//                    .addHeader()
                //.setBaseUri(Configuration.URL_AZURE)
                .setBaseUri("http://fakerestapi.azurewebsites.net")
                .setContentType(ContentType.JSON)
                .build();
    }
}
