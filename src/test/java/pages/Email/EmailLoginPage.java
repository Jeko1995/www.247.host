package pages.Email;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class EmailLoginPage extends BasePage {

    // Constructor
    public EmailLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Elements
    @FindBy(id = "username")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = "input[type='submit']")
    private WebElement loginBtn;

    // Methods i.e. actions on the page
    // This method open new tab and load email url
    public EmailLoginPage openEmailLoginPage(String emailUrl){

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(emailUrl);
        return this;
    }

    // This method login to the email
    public EmailLoginPage loginToEmail(String username, String password) {

        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(username);

        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        loginBtn.click();
        return this;
    }
}
