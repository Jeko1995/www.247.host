package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected WebDriver driver;

    protected JavascriptExecutor js;

    // Constructor to initialize the BasePage with a WebDriver instance.
    public BasePage(WebDriver driver) {
       this.driver = driver;
       this.js = (JavascriptExecutor) driver;
    }

    //This method enters data into the fields
    protected void enterData(WebElement element, String value) {
        element.click();
        element.clear();
        element.sendKeys(value);
    }
}