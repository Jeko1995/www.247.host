package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfileSettingsPage extends BasePage{

    // Constructor
    public ProfileSettingsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Elements

    @FindBy(id = "name")
    private WebElement firstNameInput;

    @FindBy(id = "last_name")
    private WebElement lastNameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "phone")
    private WebElement phoneInput;

    @FindBy(id = "current_password")
    private WebElement currentPasswordInput;

    @FindBy(id = "new_password")
    private WebElement newPasswordInput;

    @FindBy(id = "password_confirmation")
    private WebElement confirmationPasswordInput;

    @FindBy(css = ".btn-profile-settings-save")
    private WebElement saveChangesBtn;

    @FindBy(xpath = "//*[text()='The Name must be at least 3 characters.'" +
            " or text()='The Name must not be greater than 255 characters.'" +
            " or text()='The Name format is invalid.']")
    private WebElement nameFieldAllErrorMsg;

    @FindBy(xpath = "//*[text()='The Last Name must be at least 3 characters.'" +
            " or text()='The Last Name must not be greater than 255 characters.'" +
            " or text()='The Last Name format is invalid.']")
    private WebElement lastNameFieldAllErrorMsg;

    @FindBy(xpath = "//*[text()='Please add valid email adress.'" +
            " or text()='You already have been registered.'" +
            " or text()='The E-mail must not be greater than 255 characters.'" +
            " or text()='The E-mail format is invalid.']")
    private WebElement emailFieldAllErrorMsg;

    @FindBy(xpath = "//*[text()='The Phone must be at least 10 characters.'" +
            " or text()='The Phone format is invalid.'" +
            " or text()='The phone field is required.']")
    private WebElement phoneFieldAllErrorMsg;

    @FindBy(xpath = "//*[text()='The password is incorrect.'" +
            " or text()='The Current password field is required.']")
    private WebElement currentPasswordFieldAllErrorMsg;

    @FindBy(xpath = "//*[text()='The fields \"Password\" and \"Confirm password\" have to match!'" +
            " or text()='']")
    private WebElement newPasswordFieldAllErrorMsg;

    @FindBy(xpath = "//*[text()='Password confirmation field is required.'" +
            " or text()='The fields \"Password\" and \"Confirm password\" have to match!']")
    private WebElement confirmationPasswordFieldAllErrorMsg;

    // Methods i.e. actions on the page

}
