package apiTests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class User {
    Util util = new Util();
    String uri = "https://petstore.swagger.io/v2/";
    String userId = "5031";
    String username = "Alucard";
    String password = "12345";
    String token;

    @Test
    public void suiteDeTestes() throws IOException {
        incluirUser();
        consultarUser();
        login();
    }

    @Test
    public void incluirUser() throws IOException {
        String jsonBody = util.lerJson("src/test/resources/data/user.json");
        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
        .when()
                .post(uri + "user")
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(userId))
        ;
    }

    @Test
    public void consultarUser(){
        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get(uri + "user/" + username)
        .then()
                .log().all()
                .statusCode(200)
                .body("id", is(5031))
                .body("username", is("Alucard"))
                .body("firstName", is("Alucard"))
                .body("lastName", is("Tepes"))
                .body("email", is("alucardtepes@teste.com.br"))
                .body("password", is("12345"))
                .body("phone", is("5512934567890"))
                .body("userStatus", is(0))
        ;
    }

    @Test
    public void login(){
        String message = //Armazena a informação "message" do json de resposta
        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get(uri + "user/login?username=" + username + "&password=" + password)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body(containsString("logged in user session:"))
        .extract()
                .path("message")
        ;
        System.out.println("A mensagem é: " + message);
        token = message.substring(23); //Recebe o texto da variável "message" a partir do caractere de índice 23
        System.out.println("O token é: " + token);
    }
}
