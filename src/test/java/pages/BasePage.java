package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    //Uncomment this to use Javascript in all pages
    //protected JavascriptExecutor js;

    // Constructor to initialize the BasePage with a WebDriver instance.
    public BasePage(WebDriver driver) {
       this.driver = driver;
        //Uncomment this to use Javascript in all pages
        //this.js = (JavascriptExecutor) driver;
    }
}