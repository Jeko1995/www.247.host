package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestUtil extends DataProviders {
    public WebDriver driver;

    private String browser, targetURL;
    public String emailUrl;

    // Elements
    @FindBy(className= "phpdebugbar-close-btn")
    private WebElement phpDebugBarCloseBtn;

    // Method to set up the WebDriver and open the target URL before each test method.
    @BeforeMethod
    public void setupDriverAndOpenTargetURL() {
        try {
            readConfig("src/test/resources/config.properties");
            setupDriver();
            driver.manage().window().maximize();
            driver.get(targetURL);

            PageFactory.initElements(driver, this); // Initialize the elements

            setupCookie();
            closePhpDebugBar();
        } catch (Exception e) {
            System.out.println("An error occurred during setup of the driver: " + e.getMessage());
            tearDown();
            throw e;
        }
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
            emailUrl = properties.getProperty("email");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // Method to set up the WebDriver based on the configured browser.
    private void setupDriver() {
        if (driver == null) {
            switch (browser) {
                case "firefox", "mozilla", "mozilla firefox", "Mozilla firefox", "Mozilla Firefox", "Mozilla", "Firefox"
                        -> driver = setupFireFoxDriver();

                default -> driver = setupChromeDriver();
            }
        }
    }

    // Method to set up the ChromeDriver.
    private WebDriver setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        return driver = new ChromeDriver(options);
    }

    // Method to set up the FirefoxDriver.
    private WebDriver setupFireFoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("-private-window");
        return driver = new FirefoxDriver(options);
    }

    // Method to accept cookies
    private void setupCookie(){
        driver.manage().addCookie(new Cookie("247_host_cookie_consent", "eyJpdiI6InVFc1hibGxzQ3NsVnhqT3J4ZEd1cHc9PSIsInZhbHVlIjoiOC9aK0paWSsrUE9zWTNPU2VLUkhzR3FEc3BjZ0RwTnhHRHp5T1BmYWJCdEtQWkRtRElza2tITnNvWE1oRmdRS3JteWtVOGFxdHkrZXNIbkcwTERpdXpyTVNSV3pwVmNsbC9uaHpQckhoZGM9IiwibWFjIjoiNTI1YTdhYWViMWM4MzQ1Y2ZlMmRhN2UxNjNkMmIxYTE2ODNiM2I5NzYzZGY0NDYxMzdkZjYzMTBmMmI2MTFlMiIsInRhZyI6IiJ9"));
    }

    // Method for closing debug bar
    private void closePhpDebugBar() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
            phpDebugBarCloseBtn = wait.until(ExpectedConditions.elementToBeClickable(phpDebugBarCloseBtn));
            phpDebugBarCloseBtn.click();
       } catch (Exception e) {
            System.out.println("PHP Debug Bar close button not found, continuing without closing it.");
       }
    }
}