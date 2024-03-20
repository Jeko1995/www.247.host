package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    // Constructor to initialize the BasePage with a WebDriver instance.
    public BasePage(WebDriver driver) {
       this.driver = driver;
    }
}