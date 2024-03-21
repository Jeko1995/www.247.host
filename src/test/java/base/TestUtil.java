package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestUtil extends DataProviders {
    public WebDriver driver;

    private String browser, targetURL;

    // Method to set up the WebDriver and open the target URL before each test method.
    @BeforeMethod
    public void setupDriverAndOpenTargetURL() {
        readConfig("src/test/resources/config.properties");
        setupDriver();
        driver.get(targetURL);
    }

    // Method to close the WebDriver after each test method.
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    // Method to read configuration properties from a file.
    private void readConfig(String pathToFile) {
        try {
            FileInputStream fileInputStream = new FileInputStream(pathToFile);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            targetURL = properties.getProperty("url");
            browser = properties.getProperty("browser");
            } catch (IOException e) {
            System.out.println(e);
        }
    }

    // Method to set up the WebDriver based on the configured browser.
    private void setupDriver() {
        if (driver == null) {
            switch (browser) {
                case "chrome":
                    driver = setupChromeDriver();
                    break;
                case "firefox":
                    driver = setupFireFoxDriver();
                    break;
                default:
                    driver = setupChromeDriver();
            }
        }
    }

    // Method to set up the ChromeDriver.
    private WebDriver setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return driver = new ChromeDriver();
    }

    // Method to set up the FirefoxDriver.
    private WebDriver setupFireFoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return driver = new FirefoxDriver();
    }
}