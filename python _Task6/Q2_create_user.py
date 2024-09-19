
import requests
import time

def create_user():
    # Input data for creating a user
    name = "John"
    job = "Engineer"

    # Set the base URL
    base_url = "https://reqres.in/"

    # Record the start time
    start_time = time.time()

    # Make a POST request to the Create User endpoint
    response = requests.post(
        f"{base_url}/api/users",
        headers={"Content-Type": "application/json"},
        json={"name": name, "job": job}
    )

    # Record the end time
    end_time = time.time()

    # Check if the status code is 201 (Created)
    if response.status_code == 201:
        # Log the response
        print(response.json())

        # Extract data from the response
        response_data = response.json()
        response_name = response_data.get("name")
        response_job = response_data.get("job")
        user_id = response_data.get("id")
        created_at = response_data.get("createdAt")

        # Print the results
        print("Name:", response_name)
        print("Job:", response_job)
        print("ID:", user_id)
        print("Created At:", created_at)
    else:
        print("Failed to create user. Status Code:", response.status_code)

    # Calculate and print the time taken
    time_taken = (end_time - start_time) * 1000  # Convert to milliseconds
    print("Time taken:", time_taken, "ms")

if __name__ == "__main__":
    create_user()
