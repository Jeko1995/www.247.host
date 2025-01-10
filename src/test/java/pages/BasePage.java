package pages;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        js.executeScript("arguments[0].scrollIntoView();",element);

        element.click();
        element.clear();
        element.sendKeys(value);
    }

    @NotNull
    public static String getCurrentDateAndTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yy_HH-mm-ss"));
    }
}