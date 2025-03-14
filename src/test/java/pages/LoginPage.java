package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{

    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Elements
    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(className = "btn-login")
    private WebElement loginBtn;

    @FindBy(css = "span[role='alert']")
    private WebElement loginErrorMsg;

    @FindBy(className = "forgotten-password-link-2")
    private WebElement forgottenPasswordLink;

    @FindBy(xpath = "//span[text()='Create new account' or text()='Създай нов акаунт']")
    private WebElement createNewAccountBtn;

    // Methods i.e. actions on the page
    // This method fill in email and password field and click login button
    public ServicesPage enterUserDataAndLogin(String username, String password) {

        enterData(emailInput, username);
        enterData(passwordInput, password);

        js.executeScript("arguments[0].scrollIntoView();",loginBtn);
        loginBtn.click();
        return new ServicesPage(driver);
    }

    // Checks if the login error message is displayed
    public boolean isAtLoginPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        try {
            wait.until(ExpectedConditions.visibilityOf(loginBtn));

            return true;
        }catch (Exception e){
            System.out.println("Error: Element is not found on this page!" + e.getMessage());
            return false;
        }
    }

    //This method click forgotten password link
    public ResetPasswordPage clickForgottenPasswordLink() {

        js.executeScript("arguments[0].scrollIntoView();",forgottenPasswordLink);
        forgottenPasswordLink.click();
        return new ResetPasswordPage(driver);
    }

    //This method click create new account button
    public RegistrationPage clickCreateNewAccountBtn() {
        js.executeScript("arguments[0].scrollIntoView();",createNewAccountBtn);
        createNewAccountBtn.click();
        return new RegistrationPage(driver);
    }
}