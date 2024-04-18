package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;

public class BasePage {
    protected WebDriver driver;

    protected JavascriptExecutor js;

    // Constructor to initialize the BasePage with a WebDriver instance.
    public BasePage(WebDriver driver) {
       this.driver = driver;
       this.js = (JavascriptExecutor) driver;
    }
}