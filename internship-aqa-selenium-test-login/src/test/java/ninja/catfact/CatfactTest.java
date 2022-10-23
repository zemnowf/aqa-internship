package ninja.catfact;

import io.restassured.http.ContentType;
import ninja.catfact.pojos.FactPojo;
import ninja.catfact.pojos.UserData;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CatfactTest {
    private final static String URL = "https://catfact.ninja/";

    @Test
    public void getFactsWithLength(){
        Integer length = given().
                baseUri(URL)
                .basePath("facts?max_length=40")
                .param("max_length", 40)
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200)
                .extract().jsonPath().get("total");

        assertEquals(length, 15);
    }

    @Test
    public void getFact(){
        String fourthFact = given().baseUri(URL)
                .basePath("/facts")
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200)
                .extract().jsonPath().get("data[6].fact");

        assertEquals(fourthFact, "Every year, nearly four million cats are eaten in Asia.");
    }

    @Test
    public void getFacts(){
        FactPojo fact = new FactPojo("Every year, nearly four million cats are eaten in Asia.", 55);
        List<FactPojo> facts = given()
                .when()
                .contentType(ContentType.JSON)
                .get("https://catfact.ninja/facts")
                .then().log().all()
                .extract().body().jsonPath().getList("data", FactPojo.class);

        assertEquals(facts.get(6).getFact(), fact.getFact());
    }

}
