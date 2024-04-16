package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage extends BasePage{

    // Constructor
    public ResetPasswordPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Elements
    @FindBy(className = "reset-password-headline-go-back")
    private WebElement resetPassBackBtn;

    // Methods i.e. actions on the page
    //This method click back button on the reset password page
    public LoginPage clickBackBtn(){

        resetPassBackBtn.click();
        return new LoginPage(driver);
    }

}
