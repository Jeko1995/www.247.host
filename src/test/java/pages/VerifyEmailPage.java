package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VerifyEmailPage extends BasePage{
    // Constructor
    public VerifyEmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Elements
    @FindBy(xpath = "(//*[contains(@class, 'mr-3') and contains(@class, 'logged-user')])[2]")
    private WebElement viewBtn;

    // Methods i.e. actions on the page
    //Checks if user is аt verify email page
    public boolean isAtVerifyEmailPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        try {
            wait.until(ExpectedConditions.visibilityOf(viewBtn));
            return true;

        } catch (Exception e) {
            // If element is not visible, return false and custom error message
            System.out.println("Error: Element viewBtn is not found on VerifyEmailPage!" + e.getMessage());
            return false;
        }
    }
}
