package com.gft.es.prices.cucumberglue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class PriceStepDefsIT extends BaseStepDefs {

    private Response response;


    @When("Request filter data {int}, {string}, {int}")
    public void requestFilterDataBrandIdApplicationDateProductId(Integer brandId, String applicationDate, Integer productId) {

        Map<String, Object> request = Map.of("brandId", brandId, "productId", productId, "applicationDate", applicationDate);
        log.info("Request filter data {}", request);
        response = given()
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("http://localhost:" + port + "/api/prices")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    @Then("Respond a available {double} from prices")
    public void respondAAvailablePriceFromPrices(Double price) {
        assertNotNull(response.getBody());
        assertEquals( response.jsonPath().getDouble("price"), price);
        log.info("Respond a available price in PRICES");
    }



   /* @When("When Request filter data {int}, {string}, {int} is null")
    public void whenRequestFilterDataIsNull(Integer brandId, String applicationDate, Integer productId) {

        Map<String, Object> request = Map.of("brandId", brandId,  "applicationDate", applicationDate);
        log.info("Request filter data {}", request);
        response = given()
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("http://localhost:" + port + "/api/prices")
                .then()
                .statusCode(400)
                .extract()
                .response();
    }

    @Then("Respond a {int}")
    public void respondA(Integer status) {
        assertNotNull(response.getBody());
        assertEquals( response.jsonPath().getInt("status"), status);
        log.info("Respond a available price in PRICES");
    }*/


    @Given("A invalid request")
    public void aInvalidRequest() {
    }
    @When("Request filter data {int}, {string}")
    public void whenRequestFilterData(Integer brandId, String applicationDate) {
        Map<String, Object> request = Map.of("brandId", brandId, "applicationDate", applicationDate);
        log.info("Request filter data {}", request);
        response = given()
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("http://localhost:" + port + "/api/prices")
                .then()
                .statusCode(400)
                .extract()
                .response();
    }

    @Then("Respond data {int}")
    public void respondData(Integer status) {
        assertNotNull(response.getBody());
        assertEquals( response.jsonPath().getInt("code"), status);
        log.info("Respond a available price in PRICES");
    }


}
