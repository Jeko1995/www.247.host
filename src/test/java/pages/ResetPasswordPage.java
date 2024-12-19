package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResetPasswordPage extends BasePage{

    // Constructor
    public ResetPasswordPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Elements
    @FindBy(className = "reset-password-headline-go-back")
    private WebElement resetPassBackBtn;

    @FindBy(className = "form-control")
    private WebElement resetPassEmailInput;

    @FindBy(className = "btn-login")
    private WebElement resetPassSubmitBtn;

    @FindBy(className = "alert-success")
    private WebElement sendMailSuccessMsg;

    // Methods i.e. actions on the page
    //This method click back button on the reset password page
    public LoginPage clickBackBtn() {

        resetPassBackBtn.click();
        return new LoginPage(driver);
    }

    //This method fill in email field and submit the form
    public ResetPasswordPage enterEmailAndSubmit(String username) {

        enterData(resetPassEmailInput, username);

        js.executeScript("arguments[0].scrollIntoView();",resetPassSubmitBtn);
        resetPassSubmitBtn.click();
        return this;
    }

    //This method check that confirmation message for reset password is displayed
    public boolean checkConfirmationMsg(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        try {
            wait.until(ExpectedConditions.visibilityOf(sendMailSuccessMsg));

            return true;
        }catch (Exception e) {
            // If element is not visible, throw AssertionError
            System.out.println("Error: Message for successful send email is not found on reset password page!");
            return false;
        }
    }
}