import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;

public class AutomationTest {

    private static WebDriver driver;

    @BeforeAll
    static void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    void testSetEmailAndPassword() {

        String filePath = "file://" + System.getProperty("user.dir") + "/src/test/resources/register.html";
        driver.get(filePath);

        // Fill in the register form with credentials
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("username@domain.com");

        WebElement passwordInput = driver.findElement(By.id("psw"));
        passwordInput.sendKeys("MyStrongPassword123$");

        WebElement passwordRepeat = driver.findElement(By.id("psw-repeat"));
        passwordRepeat.sendKeys("MyStrongPassword123$");

        // Click the Register button
        WebElement registerButton = driver.findElement(By.className("registerbtn"));
        registerButton.click();

        // Wait for some time for the registration process
        try {
            Thread.sleep(5000); // 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // You can add verification steps here
    }

    @AfterAll
    static void tearDown() {
        // Close the browser
        driver.quit();
    }
}