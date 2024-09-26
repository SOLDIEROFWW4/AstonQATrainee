package lesson17;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PostmanEchoTests {
    @Test
    public void givenArgs_whenGetArgs_thenStatus200() {
        RestAssured.baseURI = "https://postman-echo.com";

        String orderReq = "{\n" +
                "        \"foo1\": \"bar1\",\n" +
                "        \"foo2\": \"bar2\"\n" +
                "    }";

        given()
                .log().all()
        .when()
                .contentType(ContentType.JSON)
                .body(orderReq)
                .get("/get")
                .then()
                    .statusCode(200)
                    .log().all();
    }
}
