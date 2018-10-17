package pl.mig.qa.api;


import groovy.transform.IndexedProperty;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.mig.qa.api.model.MyUser;
import pl.mig.qa.api.model.User;
import pl.mig.qa.api.model.error.ErrorBody;
import pl.mig.qa.api.model.error.ErrorResp;
import pl.mig.qa.api.services.ErrorService;
import pl.mig.qa.api.services.UserService;
import pl.mig.qa.api.specyfications.Specifications;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

@DisplayName("Api test")
public class ApiTest {

    //https://www.mocky.io/ stronka emuluje setwer restowy

    // Api rest do http://fakerestapi.azurewebsites.net/swagger/ui/index


    @Test
    @DisplayName("First test rest assure")
    public void firstTest(){
        RestAssured.given()
                .spec(Specifications.requestSpecBuilder())
                .when()
                .get("5a6b69ec3100009d211b8aeb")
                .then()
                .assertThat()
                .statusCode(200)
                .body("name",equalTo("Piotr"))
                .body("surname",equalTo("Kowalski"));
    }

    @Test
    @DisplayName("Second test rest assure")
    public void secondTest(){
        RestAssured.given()
                .spec(Specifications.requestSpecBuilder())
                .when()
                .get("5a6a58222e0000d0377a7789")
                .then()
                .assertThat()
                .statusCode(200)
                .body("[0].imie", is("Piotr"))
                .body("[0].nazwisko", equalTo("Kowalski"))
                .body("[0].device[0].type", equalTo("computer"));
    //            .body("[0].device[0].device.model[0].produce", equalTo("dell"));
    }

    @Test
    @DisplayName("Third test rest assure")
    public void thirdTest(){
        List<User> u = UserService.getUserList();
        assertThat(u.get(0).imie,equalTo("Piotr"));
        assertThat(u.get(0).nazwisko,equalTo("Kowalski"));
        assertThat(u.get(0).device.get(0).type,equalTo("computer"));
        assertThat(u.get(0).device.get(0).deviceModel.get(0).produce,equalTo("dell"));
        assertThat(u.get(0).device.get(0).deviceModel.get(0).screenSize,is(17.0));
    }

    @Test
    @DisplayName("Fourth test rest assure")
    public void fourthTest(){
        MyUser u = UserService.getMyUser();
        assertThat(u.name,equalTo("Piotr"));
        assertThat(u.surname,equalTo("Kowalski"));

    }

    @Test
    @DisplayName("Fifth test rest assure")
    public void fifthTest(){
        MyUser u = UserService.getMyUserResponse();
        assertThat(u.name,equalTo("Piotr"));
        assertThat(u.surname,equalTo("Kowalski"));
    }

    @Test
    @DisplayName("Sixth test rest assure")
    public void sixthTest(){
        List<User> u = UserService.getUserResponseList();
        assertThat(u.get(1).imie,equalTo("Iwona"));
        assertThat(u.get(0).nazwisko,equalTo("Kowalski"));
        assertThat(u.get(0).device.get(0).type,equalTo("computer"));
        assertThat(u.get(0).device.get(0).deviceModel.get(0).produce,equalTo("dell"));
        assertThat(u.get(0).device.get(0).deviceModel.get(0).screenSize,is(17.0));
    }

    @Test
    @DisplayName("Seventh test rest assure")
    public void seventhTest(){
        ErrorResp u = ErrorService.getError();
        System.out.println(u.error.toString());
        assertThat(u.error.code, is(400));
        assertThat(u.error.validationError, equalTo("invalid_email"));
    }
}

