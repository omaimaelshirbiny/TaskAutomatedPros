package loginFunctionTask;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAddToCart {

    public static WebDriver driver;

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        login();
    }

    public void login() {
        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    public void addToCart() {
        // Find element and add to cart
        driver.findElement(By.cssSelector("#item_4_title_link")).click();
        driver.findElement(By.id("add-to-cart")).click();

        // Validation
        driver.navigate().back();

        // Navigate add to cart page to verify adding to cart is working correctly
        driver.findElement(By.className("shopping_cart_container")).click();
    }

    @Test
    public void removeFromCart() {
        // Remove
        driver.findElement(By.cssSelector("#item_4_title_link")).click();
        driver.findElement(By.id("add-to-cart")).click();
        driver.findElement(By.className("shopping_cart_container")).click();
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/button")).click();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

