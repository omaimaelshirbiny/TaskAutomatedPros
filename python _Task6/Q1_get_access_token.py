
import requests
import time

def get_access_token():
    # Input data for login
    email = "omaima@gmail.com"
    password = "1234"

    # Set the base URL
    base_url = "https://reqres.in/"

    # Record the start time
    start_time = time.time()

    # Make a POST request to the login endpoint
    response = requests.post(
        f"{base_url}/api/register",
        headers={"Content-Type": "application/json"},
        json={"email": email, "password": password}
    )

    # Record the end time
    end_time = time.time()

    # Check if the status code is 200 (OK)
    if response.status_code == 200:
        # Log the response
        print(response.json())

        # Extract the token from the response
        token = response.json().get("token")
        print("Token:", token)
    else:
        print("Failed to retrieve token. Status Code:", response.status_code)

    # Calculate and print the time taken
    time_taken = (end_time - start_time) * 1000  # Convert to milliseconds
    print("Time taken:", time_taken, "ms")

if __name__ == "__main__":
    get_access_token()
