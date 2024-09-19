
import requests
import time

def update_user():
    # Input data for updating a user
    name = "Jane"
    job = "Manager"

    # Set the base URL
    base_url = "https://reqres.in/"

    # Record the start time
    start_time = time.time()

    # Make a PUT request to the Update User endpoint
    response = requests.put(
        f"{base_url}/api/users/2",  # Assuming we are updating user with ID 2
        headers={"Content-Type": "application/json"},
        json={"name": name, "job": job}
    )

    # Record the end time
    end_time = time.time()

    # Check if the status code is 200 (OK)
    if response.status_code == 200:
        # Log the response
        print(response.json())

        # Extract data from the response
        response_data = response.json()
        response_name = response_data.get("name")
        response_job = response_data.get("job")
        updated_at = response_data.get("updatedAt")

        # Print the results
        print("Name:", response_name)
        print("Job:", response_job)
        print("Updated At:", updated_at)
    else:
        print("Failed to update user. Status Code:", response.status_code)

    # Calculate and print the time taken
    time_taken = (end_time - start_time) * 1000  # Convert to milliseconds
    print("Time taken:", time_taken, "ms")

if __name__ == "__main__":
    update_user()
