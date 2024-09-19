package apiTask;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TaskQ4 {

    @Test
    public void deleteUser() {
        // Set the base URI
        RestAssured.baseURI = "https://reqres.in/";

        // Record the start time
        long startTime = System.currentTimeMillis();

        // Make a DELETE request to the Delete User endpoint
        Response response = given()
                .when()
                .delete("/api/users/2")  // Assuming we are deleting user with ID 2
                .then()
                .log().all()  // Log the response
                .assertThat().statusCode(204)  // Check if the status code is 204 (No Content)
                .extract().response();

        // Record the end time
        long endTime = System.currentTimeMillis();

        // Calculate the time taken
        long timeTaken = endTime - startTime;

        // Print the time taken
        System.out.println("Time taken: " + timeTaken + " ms");
    }
}
