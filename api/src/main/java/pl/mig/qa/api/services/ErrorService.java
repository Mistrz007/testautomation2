package pl.mig.qa.api.services;

import io.restassured.RestAssured;
import pl.mig.qa.api.model.error.ErrorBody;
import pl.mig.qa.api.model.error.ErrorResp;
import pl.mig.qa.api.specyfications.Specifications;

public class ErrorService {
    public static final String error_Patch = "5a690b452e000054007a73cd";

    public static ErrorResp getError(){
        return RestAssured.given()
                .spec(Specifications.requestSpecBuilder())
                .when()
                .get(error_Patch)
                .then()
                .assertThat()
                .statusCode(400)
                .extract()
                .body()
                .as(ErrorResp.class);
    }
}
