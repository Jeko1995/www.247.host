package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BasePage{

    // Constructor
    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Elements
    @FindBy(id = "full-name")
    private WebElement firstAndLastNameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "password_confirmation")
    private WebElement confirmationPasswordInput;

    @FindBy(className = ".select2-selection.select2-selection--single")
    private WebElement countryDropdown;

    @FindBy(css= "[name=\"city\"]")
    private WebElement cityInput;

    @FindBy(css= "[name=\"address\"]")
    private WebElement addressInput;

    @FindBy(css= "[name=\"postCode\"]")
    private WebElement postCodeInput;

    @FindBy(id = "phone")
    private WebElement phoneInput;

    @FindBy(css= "[name=\"terms\"]")
    private WebElement termsCheckbox;

    @FindBy(className = ".btn-register")
    private WebElement registerBtn;

    @FindBy(xpath = "//*[text()='The full name field is required.'" +
            " or text()='Полето за име и фамилия е задължително.']")
    private WebElement fullNameFieldErrorMsg;

    // Methods i.e. actions on the page

}
