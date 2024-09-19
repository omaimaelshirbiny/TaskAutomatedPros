package apiTask;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TaskQ3 {

    @Test
    public void updateUser() {
        // Input data for updating a user
        String name = "Jane ";
        String job = " Manager";

        // Set the base URI
        RestAssured.baseURI = "https://reqres.in/";

        // Record the start time
        long startTime = System.currentTimeMillis();

        // Make a PUT request to the Update User endpoint
        Response response = given()
                .header("Content-Type", "application/json")
                .body("{ \"name\": \"" + name + "\", \"job\": \"" + job + "\" }")
                .when()
                .put("/api/users/2")  // Assuming we are updating user with ID 2
                .then()
                .log().all()  // Log the response
                .assertThat().statusCode(200)  // Check if the status code is 200 (OK)
                .extract().response();

        // Record the end time
        long endTime = System.currentTimeMillis();

        // Extract data from the response
        String responseName = response.jsonPath().getString("name");
        String responseJob = response.jsonPath().getString("job");
        String updatedAt = response.jsonPath().getString("updatedAt");

        // Calculate the time taken
        long timeTaken = endTime - startTime;

        // Print the results
        System.out.println("Name: " + responseName);
        System.out.println("Job: " + responseJob);
        System.out.println("Updated At: " + updatedAt);
        System.out.println("Time taken: " + timeTaken + " ms");
    }
}
