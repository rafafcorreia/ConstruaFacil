package apiTests;


import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.stringContainsInOrder;

public class Pet {
    String petId = "3031";
    String jsonBody;
    String urlPet = "https://petstore.swagger.io/v2/pet/";

   /* @Test
    public void suiteDeTestes() throws IOException {
        incluirPet();
        consultarPet();
        alterarPet();
        deletarPet();
    }
    */

    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    //POST
    @Test(priority = 1)
    public void incluirPet() throws IOException {
        //Given
        jsonBody = lerJson("src/test/resources/data/pet.json");
        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
        //When
        .when()
                .post(urlPet)
        //Then
        .then()
                .log().all()
                .statusCode(200)
                .body("id", is(3031))
                .body("category.id", is(1))
                .body("category.name", is("cat"))
                .body("name", is("Esmeralda"))
                .body("tags[1].id", is(1))
                .body("tags[1].name", is("int"));
    }

    //GET
    @Test (priority = 2, dependsOnMethods = {"incluirPet"})
    public void consultarPet(){
        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get(urlPet + petId)
        .then()
                .log().all()
                .statusCode(200)
                .body("name", is("Esmeralda"))
                .body("id", is(3031))
                .body("category.name", is("cat"))
                .body("status", is("available"))
                .body("tags[1].id", is(1))
                .body("tags[1].name", is("int"));
    }

    @Test (priority = 3, dependsOnMethods = {"consultarPet"})
    public void alterarPet() throws IOException {
        jsonBody = lerJson("src/test/resources/data/pet2.json");

        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
        .when()
                .put(urlPet)
        .then()
                .log().all()
                .statusCode(200)
                .body("name", is("Lazuli"))
                .body("tags[0].name", stringContainsInOrder("Az"));
    }

    @Test (priority = 4, dependsOnMethods = {"alterarPet"})
    public void deletarPet(){
        given()
                .contentType("application/json")
                .log().all()
        .when()
                .delete(urlPet + petId)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("message", is(petId));
    }
}
