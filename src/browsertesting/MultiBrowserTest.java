package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTest {
    static String browser = "chrome";
    static String baseUrl = "https://www.saucedemo.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gheko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            System.out.println("Wrong browser name");
        }

        //Launch URL
        driver.get(baseUrl);

        //Maximize window
        driver.manage().window().maximize();

        //We give implicit time to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Get the title of page
        System.out.println("Page title is : " + driver.getTitle());

        //Get current url
        System.out.println("Current url is " + driver.getCurrentUrl());

        //Get page source
        System.out.println("Page source is : " + driver.getPageSource());

        //Enter username in username field
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("Testing");

        //Enter password in password field
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("testing123");

        //close the driver
        driver.close();
    }
}
