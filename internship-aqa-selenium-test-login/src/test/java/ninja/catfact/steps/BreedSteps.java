package ninja.catfact.steps;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import ninja.catfact.pojos.BreedPojo;

import java.util.List;

import static io.restassured.RestAssured.given;

public class BreedSteps {
    private static final RequestSpecification REQUEST_SPECIFICATION_BREEDS =
            new RequestSpecBuilder()
                    .setBaseUri("https://catfact.ninja/")
                    .setBasePath("breeds").build();

    @Step("Receiving of breeds")
    public static List<BreedPojo> getBreeds(){
        return given().spec(REQUEST_SPECIFICATION_BREEDS)
                .param("limit", 50)
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200)
                .extract().jsonPath().getList("data", BreedPojo.class);
    }

    @Step("Receiving of amount ({limit}) of breeds")
    public static Integer getLimit(Integer limit) {
        return given().spec(REQUEST_SPECIFICATION_BREEDS)
                .param("limit", limit)
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200)
                .extract().jsonPath().get("to");
    }
}
