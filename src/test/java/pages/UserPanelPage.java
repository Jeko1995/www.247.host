package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserPanelPage extends BasePage{

    // Constructor
    public UserPanelPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Elements
    @FindBy(css = ".logged-user.mr-3")
    private WebElement loggedUserNameAndIcon;

    // Methods i.e. actions on the page
    //Checks if user is аt current page
    public boolean isAt() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        try {
            wait.until(ExpectedConditions.visibilityOf(loggedUserNameAndIcon));

            return true;
        } catch (Exception e) {
            // If element is not visible, return false and custom error message
            System.out.println("Error: Element is not found on this page!");
            return false;
        }
    }
}