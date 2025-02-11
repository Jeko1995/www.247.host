package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class TestUtil extends DataProviders {
    public WebDriver driver;

    private String browser, targetURL;
    public static final String TEST_RESOURCES_DIR = "src\\test\\resources\\";
    public static final String SCREENSHOTS_DIR = TEST_RESOURCES_DIR.concat("screenshots\\");

    // Elements
    @FindBy(className= "phpdebugbar-close-btn")
    private WebElement phpDebugBarCloseBtn;

    // Method to set up the WebDriver and open the target URL before each test method.
    @BeforeMethod
    protected final void setupDriverAndOpenTargetURL() throws IOException {
        try {
            readConfig();
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

    //This method delete all old screenshots before each test suite
    @BeforeSuite
    protected final void setupTestSuite() throws IOException {
        cleanDirectory();
    }

    // Method to close the WebDriver and make screenshot after each test method.
    @AfterMethod
    protected final void tearDownTest(ITestResult testResult) {
        takeScreenshot(testResult);
        if (this.driver != null) {
            this.driver.quit();
            this.driver = null;
        }
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    // Method to read configuration properties from a file.
    private void readConfig() throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);
            targetURL = properties.getProperty("url");
            browser = properties.getProperty("browser");
        } catch (IOException e) {
            throw (e);
        }
    }

    // Method to set up the WebDriver based on the configured browser.
    private void setupDriver() {
        if (driver == null) {
            switch (browser) {
                case "firefox", "mozilla", "mozilla firefox", "Mozilla firefox", "Mozilla Firefox", "Mozilla", "Firefox"
                        -> setupFireFoxDriver();

                default -> setupChromeDriver();
            }
        }
    }

    // Method to set up the ChromeDriver.
    private void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
    }

    // Method to set up the FirefoxDriver.
    private void setupFireFoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
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

    //Takes a screenshot upon test failure
    private void takeScreenshot(ITestResult testResult){
        if(ITestResult.FAILURE == testResult.getStatus()){
            try{
                TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
                File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
                String testName = testResult.getName() + "_" + getCurrentDateAndTime();
                FileUtils.copyFile(screenshot, new File(SCREENSHOTS_DIR.concat(testName).concat(".jpg")));
            }catch (IOException e){
                System.out.println("Unable to create screenshot file: " + e.getMessage());
            }
        }
    }

    //Cleans files in a directory provided as input parameter
    private void cleanDirectory() throws IOException {
        File directory = new File(TestUtil.SCREENSHOTS_DIR);

        File screenshotDir = new File(SCREENSHOTS_DIR);

        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();
        }

        Assert.assertTrue(directory.isDirectory(), "Correct directory for saving screenshots is not created!");

        FileUtils.cleanDirectory(directory);
        String[] fileList = directory.list();
        if (fileList != null && fileList.length == 0) {
            System.out.printf("All files are deleted in Directory: %s%n", SCREENSHOTS_DIR);
        } else {
            System.out.printf("Unable to delete the files in Directory:%s%n", SCREENSHOTS_DIR);
        }
    }

    //This method gets the current date and time and formats it
    @NotNull
    public static String getCurrentDateAndTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yy_HH-mm-ss"));
    }
}