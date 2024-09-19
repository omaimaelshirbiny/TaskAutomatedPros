package loginFunctionTask;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestLoginFunction {

    public static void main(String[] args) {

        TestLoginFunction t = new TestLoginFunction();
        t.login();
    }

    @Test
    public void login (){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // URL of the login website that is tested
        driver.get("https://www.saucedemo.com/");
        // Maximize window size of browser
        driver.manage().window().maximize();
        // Enter your login email id
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // Enter your login password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //click button
        driver.findElement(By.id("login-button")).click();

        driver.quit();
    }
}
