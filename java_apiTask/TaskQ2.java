package apiTask;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TaskQ2 {

    @Test
    public void createUser() {
        // Input data for creating a user
        String name = "John ";
        String job = " Engineer";

        // Set the base URI
        RestAssured.baseURI = "https://reqres.in/";

        // Record the start time
        long startTime = System.currentTimeMillis();

        // Make a POST request to the Create User endpoint
        Response response = given()
                .header("Content-Type", "application/json")
                .body("{ \"name\": \"" + name + "\", \"job\": \"" + job + "\" }")
                .when().post("/api/users")
                .then()
                .log().all()  // Log the response
                .assertThat().statusCode(201)  // Check if the status code is 201 (Created)
                .extract().response();

        // Record the end time
        long endTime = System.currentTimeMillis();

        // Extract data from the response
        String responseName = response.jsonPath().getString("name");
        String responseJob = response.jsonPath().getString("job");
        String id = response.jsonPath().getString("id");
        String createdAt = response.jsonPath().getString("createdAt");

        // Calculate the time taken
        long timeTaken = endTime - startTime;

        // Print the results
        System.out.println("Name: " + responseName);
        System.out.println("Job: " + responseJob);
        System.out.println("ID: " + id);
        System.out.println("Created At: " + createdAt);
        System.out.println("Time taken: " + timeTaken + " ms");
    }
}
