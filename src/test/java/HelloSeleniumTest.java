import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.*;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.concurrent.TimeUnit;



class HelloSeleniumTest {

    final private String testURL = "https://jonathan-chat-springboot.herokuapp.com";

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.out.println("Test starting...");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.out.println("Test completed.");
    }

    @Test
    @DisplayName("Getting the title of a website")
    public void testTitle() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver;
        driver = new ChromeDriver();
        //Go to https://jonathan-chat-springboot.herokuapp.com
        driver.get(testURL);
        //Check title is correct
        Assertions.assertEquals(driver.getTitle(), "Welcome to Spring Boot Chat Application");
        System.out.println(driver.getTitle());
    }

    @Test
    @DisplayName("Find name input box on website and fill with name")
    public void testNameInput() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get(testURL);
        WebElement nameBox = driver.findElement(By.id("name"));
        nameBox.sendKeys("Test name");
    }

    @Test
    @DisplayName("Find name input box on website and push start button to enter chat")
    public void testEnterChatWithoutName() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get(testURL);
        WebElement nameBox = driver.findElement(By.id("name"));
        nameBox.sendKeys("Test name and enter button");
        WebElement nameButton = driver.findElement(By.className("username-submit"));
        nameButton.click();
    }
}