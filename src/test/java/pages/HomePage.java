package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{

    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Elements
    @FindBy(css= ".btn-login-navbar.mr-lg-2")
    private WebElement loginBtn;

    // Methods i.e. actions on the page
    // This method click on the login button
    public LoginPage clickLoginBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();

    return new LoginPage(driver);
    }
}
