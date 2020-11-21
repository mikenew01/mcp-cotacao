package com.github.maikoncanuto.quotes.resources;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

@QuarkusTest
class MoedaResourceTest {

    private final static String PATH_API = "/api/v1/moedas";

    @Test
    void testRetornoEndpointFindAllMoedas() {
        given()
                .when()
                .get(PATH_API)
                .then()
                .statusCode(200)
                .body("code", is(String.valueOf(200)))
                .body("erro", nullValue())
                .body("data", notNullValue())
                .body("data.size()", is(1));
    }


}
