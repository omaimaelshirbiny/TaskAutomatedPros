package apiTask;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TaskQ1 {

    @Test
    public void getAccessToken() {
        // Input data for login
        String email = "omaima@gmail.com";
        String password = "1234";

        // Set the base URI
        RestAssured.baseURI = "https://reqres.in/";

        // Record the start time
        long startTime = System.currentTimeMillis();

        // Make a POST request to the login endpoint
        Response response = given()
                .header("Content-Type", "application/json")
                .body("{ \"email\": \"" + email + "\", \"password\": \"" + password + "\" }")
                .when()
                .post("/api/register")
                .then()
                .log().all()  // Log the response
                .assertThat().statusCode(200)  // Check if the status code is 200 (ok)
                .extract().response();

        // Record the end time
        long endTime = System.currentTimeMillis();

        // Extract the token from the response
        String token = response.jsonPath().getString("token");
        System.out.println("Token: " + token);

        // Calculate and print the time taken
        long timeTaken = endTime - startTime;
        System.out.println("Time taken: " + timeTaken + " ms");
    }
}
