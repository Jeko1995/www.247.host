package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Elements
    @FindBy(className = "btn-login-navbar mr-lg-2 mr-xl-3 mr-xxl-4 mr-xxxl-6")
    private WebElement loginBtn;

    // Methods i.e. actions on the page
    public LoginPage clickLoginBtn() {
    loginBtn.click();
    return new LoginPage(driver);
    }
}
