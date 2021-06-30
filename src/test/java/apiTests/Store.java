package apiTests;

import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class Store {
    Util util = new Util();
    String uri = "https://petstore.swagger.io/v2/";

    @Test
    public void incluirPedido() throws IOException {
        String jsonBody = util.lerJson("src/test/resources/data/store.json");
        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
        .when()
                .post(uri + "store/order")
        .then()
                .log().all()
                .statusCode(200)
                .body("id", is(5050))
                .body("petId", is(3031))
                .body("quantity", is(1))
                .body("shipDate", is("2021-06-30T16:24:12.543+0000"))
                .body("status", is("placed"))
                .body("complete", is(true))
        ;
    }
}
