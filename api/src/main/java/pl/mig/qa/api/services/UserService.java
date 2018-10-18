package pl.mig.qa.api.services;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pl.mig.qa.api.model.MyUser;
import pl.mig.qa.api.model.User;
import pl.mig.qa.api.model.UserAzure;
import pl.mig.qa.api.specyfications.Specifications;

import java.util.Arrays;
import java.util.List;

public class UserService {
    public static final String myUser_Patch = "5a6b69ec3100009d211b8aeb";
    public static final String user_Patch = "5a6a58222e0000d0377a7789";
    public static final String USER_PATCH_POST = "5a690a1b2e000051007a73cb";
    public static final String USER_PATCH_POST_GENERIC1 = "5b05bf3f3200007100ebfa04";
    public static final String USER_PATCH_POST_GENERIC2 = "5b05c83e3200009700ebfa2b";

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
                .get(user_Patch)
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


    public static List<User> getUserResponseList(){

        return Arrays.asList(RestAssured.given()
                .spec(Specifications.requestSpecBuilder())
                .when()
                .get(user_Patch)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .as(User[].class));
    }

    public static String[] postMyUser(MyUser myUser){
          return RestAssured.given()
                .spec(Specifications.requestSpecBuilder())
                .when()
                .body(myUser)
                .post(USER_PATCH_POST)
                .andReturn()
                  .then()
                  .assertThat()
                  .statusCode(201)
                  .extract()
                  .as(String[].class);
    }
    public static Response getGeneric1(){
        return RestAssured.given()
                .spec(Specifications.requestSpecBuilder())
                .when()
                .get(USER_PATCH_POST_GENERIC1)
                .andReturn();
    }
    public static Response getGeneric2(){
        return RestAssured.given()
                .spec(Specifications.requestSpecBuilder())
                .when()
                .get(USER_PATCH_POST_GENERIC2)
                .andReturn();
    }

    public static UserAzure getUserAzure(long id){
        return RestAssured.given()
                .spec(Specifications.requestSpecBuilderUserAzure())
                //.queryParam("name","piotr")
                .when()
                .get("/api/Users/{id}",id)
                .andReturn()
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .as(UserAzure.class);
    }

}
