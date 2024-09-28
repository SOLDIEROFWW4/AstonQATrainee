package lesson17;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostmanEchoTests {

    private final static String postmanEchoPath = "https://postman-echo.com";

    @Test
    public void givenArgs_whenGetArgs_thenStatus200() {
        RestAssured.baseURI = postmanEchoPath;

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

    @Test
    public void whenRawTextCreated_thenStatus200() {
        RestAssured.baseURI = postmanEchoPath;

        String rawText = "{\n " +
                "\"test\": \"value\"\n" +
                "}";

        given()
                .contentType("text/plain")
                .body(rawText)
                .log().all()
        .when()
                .post("/post")
        .then()
                .statusCode(200)
                .log().all()
                .body("data", equalTo(rawText));
    }

    @Test
    public void whenPostFormData_thenStatus200() {
        RestAssured.baseURI = postmanEchoPath;

        given()
                .contentType("application/json")
                .body("{" +
                        "\"foo1\":\"bar1\", " +
                        "\"foo2\":\"bar2\"" +
                        "}")
                .log().all()
        .when()
                .post("/post")
        .then()
                .statusCode(200) 
                .log().all()
                .body("data.foo1", equalTo("bar1"))
                .body("data.foo2", equalTo("bar2"));
    }

    @Test
    public void whenUpdateText_thenStatus200() {
        RestAssured.baseURI = postmanEchoPath;

        String requestBody = "This is expected to be sent back as part of response body.";

        Response response =
        given()
                .queryParam("hand", "wave")
                .header("Content-Type", "text/plain")
                .body(requestBody)
        .when()
                .put("/put")
        .then()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .extract()
                .response();

        System.out.println("Response Body:");
        System.out.println(response.getBody().asString());
    }

    @Test
    public void whenSemiUpdateText_thenStatus200() {
        RestAssured.baseURI = postmanEchoPath;

        String requestBody = "This is expected to be sent back as part of response body.";

        Response response =
        given()
                .contentType("text/plain")
                .body(requestBody)
                .log().all()
        .when()
                .patch("/patch")
        .then()
                .statusCode(200)
                .log().all()
                .body("data", equalTo(requestBody))
                .extract()
                .response();

        System.out.println("Response Body:");
        System.out.println(response.getBody().asString());
    }

    @Test
    public void givenRawText_whenDeleteText_thenStatus200() {
        RestAssured.baseURI = postmanEchoPath;

        String requestBody = "This is expected to be sent back as part of response body.";

        Response response =
        given()
                .contentType("text/plain")
                .body(requestBody)
                .log().all()
        .when()
                .delete("/delete")
        .then()
                .statusCode(200)
                .log().all()
                .body("data", equalTo(requestBody))
                .extract()
                .response();

        System.out.println("Response Body:");
        System.out.println(response.getBody().asString());
    }
}
