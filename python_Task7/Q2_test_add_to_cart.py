
import unittest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager

class TestAddToCart(unittest.TestCase):

    @classmethod
    def setUpClass(cls):
        # Setup the Chrome WebDriver
        cls.driver_service = Service(ChromeDriverManager().install())

    def setUp(self):
        # Initialize the WebDriver
        self.driver = webdriver.Chrome(service=self.driver_service)
        self.driver.maximize_window()
        self.driver.get("https://www.saucedemo.com/")
        self.login()

    def login(self):
        # Perform login
        self.driver.find_element(By.ID, "user-name").send_keys("standard_user")
        self.driver.find_element(By.ID, "password").send_keys("secret_sauce")
        self.driver.find_element(By.ID, "login-button").click()

    def test_add_to_cart(self):
        # Find element and add to cart
        self.driver.find_element(By.CSS_SELECTOR, "#item_4_title_link").click()
        self.driver.find_element(By.ID, "add-to-cart-sauce-labs-backpack").click()  # Updated ID selector for the button

        # Validation - navigate back
        self.driver.back()

        # Navigate to cart page to verify adding to cart
        self.driver.find_element(By.CLASS_NAME, "shopping_cart_container").click()

    def test_remove_from_cart(self):
        # Add item to cart first
        self.driver.find_element(By.CSS_SELECTOR, "#item_4_title_link").click()
        self.driver.find_element(By.ID, "add-to-cart-sauce-labs-backpack").click()  # Updated ID selector for the button

        # Navigate to cart
        self.driver.find_element(By.CLASS_NAME, "shopping_cart_container").click()

        # Remove item from cart
        self.driver.find_element(By.XPATH, "//button[text()='Remove']").click()  # Updated XPath to match the remove button

    def tearDown(self):
        if self.driver:
            self.driver.quit()

if __name__ == "__main__":
    unittest.main()
