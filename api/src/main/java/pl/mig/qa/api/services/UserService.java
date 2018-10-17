package pl.mig.qa.api.services;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import pl.mig.qa.api.model.MyUser;
import pl.mig.qa.api.model.User;
import pl.mig.qa.api.specyfications.Specifications;

import java.util.List;

public class UserService {
    public static final String myUser_Patch = "5a6b69ec3100009d211b8aeb";
    public static final String user_Patch = "5a6a58222e0000d0377a7789";

    public static MyUser getMyUser(){
        return RestAssured.given()
                .spec(Specifications.requestSpecBuilder())
                .when()
                .get(myUser_Patch)
                .then()
                .assertThat()
                .statusCode(200)
                .extract().body()
                .jsonPath()
                .getObject("",MyUser.class);
    }

    public static List<User> getUserList(){
        return RestAssured.given()
                .spec(Specifications.requestSpecBuilder())
                .when()
                .get("5a6a58222e0000d0377a7789")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().body()
                .jsonPath().getList("",User.class);
    }

    public static MyUser getMyUserResponse(){
        return RestAssured.given()
                .spec(Specifications.requestSpecBuilder())
                .when()
                .get(myUser_Patch)
                .andReturn()
                .then()
                .extract()
                .body()
                .as(MyUser.class);
    }
}
