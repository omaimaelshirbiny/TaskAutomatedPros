
from selenium import webdriver
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager

class TestLoginFunction:
    
    def login(self):
        # Set up the WebDriver
        driver = webdriver.Chrome(ChromeDriverManager().install())

        # URL of the login website that is tested
        driver.get("https://www.saucedemo.com/")
        # Maximize window size of the browser
        driver.maximize_window()
        # Enter the login username
        driver.find_element(By.ID, "user-name").send_keys("standard_user")
        # Enter the login password
        driver.find_element(By.ID, "password").send_keys("secret_sauce")
        # Click the login button
        driver.find_element(By.ID, "login-button").click()

        # Close the browser
        driver.quit()

if __name__ == "__main__":
    test = TestLoginFunction()
    test.login()
