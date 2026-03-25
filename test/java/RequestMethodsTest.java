import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;

public class RequestMethodsTest {
    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    @DisplayName("Проверка метода GET: код 200 и возврат параметров")
    public void testGetMethod() {
        given()
                .queryParam("foo1","bar1")
                .queryParam("foo2", "bar2")

                .when()
                .get("/get")
                .then()
                .assertThat()
                .statusCode(200)
                .body("args.foo1",equalTo("bar1"))
                .body("args.foo2",equalTo("bar2"));
    }


    @Test
    @DisplayName("POST: код 200")
    public void testPostMethod() {

        String jsonBody = "{\"foo1\":\"bar1\", \"foo2\":\"bar2\"}";

        given()
                .contentType("application/json")  // Важно!
                .body(jsonBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                // Проверяем, что данные вернулись в поле "json"
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"));
    }

    @Test
    @DisplayName("POST(raw data): код 200")
    public void testPostRawData() {

        String textBody = "{\n    \"test\": \"value\"\n}";

        given()
                .contentType("text/plain")
                .body(textBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(textBody));
    }


    @Test
    @DisplayName("PUT: код 200")
    public void testPutMethod() {

        String textBody = "This is expected to be sent back as part of response body.";

        given()
                .contentType("text/plain")
                .body(textBody)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data", equalTo(textBody));
    }

    @Test
    @DisplayName("PATCH: код 200")
    public void testPatchMethod() {

        String textBody = "This is expected to be sent back as part of response body.";

        given()
                .contentType("text/plain")
                .body(textBody)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data", equalTo(textBody));

    }

    @Test
    @DisplayName("DELETE: код 200")
    public void testDeleteMethod() {

        String textBody = "This is expected to be sent back as part of response body.";

        given()
                .contentType("text/plain")
                .body(textBody)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("data", equalTo(textBody));


    }

}
