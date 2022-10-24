package ninja.catfact.steps;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import ninja.catfact.pojos.FactPojo;

import java.util.List;

import static io.restassured.RestAssured.given;

public class FactSteps {
    private static final RequestSpecification REQUEST_SPECIFICATION_FACTS =
            new RequestSpecBuilder()
                    .setBaseUri("https://catfact.ninja/")
                    .setBasePath("facts").build();

    @Step("Receiving of facts")
    public static List<FactPojo> getFacts(){
        return given().spec(REQUEST_SPECIFICATION_FACTS)
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200)
                .extract().jsonPath().getList("data", FactPojo.class);
    }

    @Step("Receiving of facts with given length ({length}) of fact")
    public static Integer getTotal(Integer length){
        return given().
                spec(REQUEST_SPECIFICATION_FACTS)
                .param("max_length", length)
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200)
                .extract().jsonPath().get("total");
    }
}
