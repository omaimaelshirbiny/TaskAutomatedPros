package loginFunctionTask;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;

public class TestAddToCartSteps {

    public static WebDriver driver;


    public void login()  {
        // open browser and maximize
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        //login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

    }


    public void addToCart ()  {
        //find element
        driver.findElement(By.cssSelector("#item_4_title_link")).click();

        //add to cart
        driver.findElement(By.id("add-to-cart")).click();

        //validation
        driver.navigate().back();

        //navigate add to cart page to verify adding to cart is working correctly
        driver.findElement(By.className("shopping_cart_container")).click();

    }


    public void removeFromCart () throws InterruptedException {
//        remove
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/button")).click();
        Thread.sleep(2000);
    }


    public static void main(String[] args) throws InterruptedException {


        TestAddToCartSteps a = new TestAddToCartSteps();
        a.login();
        a.addToCart();
        a.removeFromCart();
        driver.quit();

    }


}
