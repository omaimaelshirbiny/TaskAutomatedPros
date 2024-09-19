
import requests
import time

def delete_user():
    # Set the base URL
    base_url = "https://reqres.in/"

    # Record the start time
    start_time = time.time()

    # Make a DELETE request to the Delete User endpoint
    response = requests.delete(f"{base_url}/api/users/2")  # Assuming we are deleting user with ID 2

    # Record the end time
    end_time = time.time()

    # Log the response status code
    print("Status Code:", response.status_code)

    # Check if the status code is 204 (No Content)
    if response.status_code == 204:
        print("User deleted successfully.")
    else:
        print("Failed to delete user. Status Code:", response.status_code)

    # Calculate and print the time taken
    time_taken = (end_time - start_time) * 1000  # Convert to milliseconds
    print("Time taken:", time_taken, "ms")

if __name__ == "__main__":
    delete_user()
