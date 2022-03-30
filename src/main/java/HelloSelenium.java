import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class HelloSelenium {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriverManager.safaridriver().setup();
        WebDriverManager.firefoxdriver().setup();

        WebDriver webDriver;
        webDriver = new ChromeDriver();

        webDriver.get("https://jonathan-chat-springboot.herokuapp.com/");


        System.out.println(webDriver.getTitle());
        System.out.println(webDriver.getCurrentUrl());
        System.out.println(webDriver.getPageSource());

        webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        Thread.sleep(5 * 1000);

        //
        WebElement nameBox = webDriver.findElement(By.id("name"));
        WebElement nameButton = webDriver.findElement(By.className("username-submit"));

        //Skriv något i textrutan
        nameBox.sendKeys("Jonathan");

        //System.out.println(searchBox.getAttribute("value"));

        nameButton.click();

       /* searchBox = webDriver.findElement(By.name("q"));
        searchBox .getAttribute("value");*/

        //webDriver.quit();



    }

}
