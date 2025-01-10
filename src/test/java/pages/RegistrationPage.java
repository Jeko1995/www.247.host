package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    @FindBy(className = "btn-register")
    private WebElement registerBtn;

    @FindBy(xpath = "//*[text()='The full name field is required.'" +
            " or text()='The full name must be at least 6 characters.'" +
            " or text()='The full name must not be greater than 255 characters.'" +
            " or text()='The full name format is invalid.'" +
            " or text()='The name must be at least 3 characters.' " +
            " or text()='The last name must be at least 3 characters.'" +
            " or text()='Полето за име и фамилия е задължително.'" +
            " or text()='Полето Име и фамилия трябва да бъде минимум 6 знака.'" +
            " or text()='Полето Име и фамилия трябва да бъде по-малко от 255 знака.'" +
            " or text()='Полето Име и фамилия е в невалиден формат.'" +
            " or text()='Името трябва да съдържа поне 3 символа.'" +
            " or text()='Фамилията трябва да съдържа поне 3 символа.'] ")
    private WebElement fullNameFieldAllErrorMsg;

    @FindBy(xpath = "//*[text()='Email field is required.'" +
            " or text()='Please add valid email adress.'" +
            " or text()='You already have been registered.'" +
            " or text()='The E-mail must not be greater than 255 characters.'" +
            " or text()='Полето за e-mail е задължително.'" +
            " or text()='Моля въведете валиден e-mail.'" +
            " or text()='Този имейл е вече регистриран.'" +
            " or text()='Полето Ел. поща трябва да бъде по-малко от 255 знака.']")
    private WebElement emailFieldAllErrorMsg;

    @FindBy(xpath = "//*[text()='Password field is required.'" +
            " or text()='The password must contain at least 8 characters, one uppercase letter, one lowercase letter, one number, and one symbol.'" +
            " or text()='Полето за парола е задължително.'" +
            " or text()='Полето трябва да съдържа минимум 8 знака, 1 главна буква, 1 малка буква, символ и цифра.']")
    private WebElement passwordFieldAllErrorMsg;

    @FindBy(xpath = "//*[text()='Password confirmation field is required.'" +
            " or text()='The fields \"Password\" and \"Confirm password\" have to match!'" +
            " or text()='Полето за потвърждение на паролата е задължително.'" +
            " or text()='Полетата \"Парола\" и \"Потвърдете паролата\" трябва да съвпадат!']")
    private WebElement confirmationPasswordFieldAllErrorMsg;

    @FindBy(xpath = "//*[text()='Country must be a valid selection.'" +
            " or text()='Полето за държава е задължително.']")
    private WebElement countryDropdownAllErrorMsg;

    @FindBy(xpath = "//*[text()='City is required.'" +
            " or text()='Полето за град е задължително.']")
    private WebElement cityFieldAllErrorMsg;

    @FindBy(xpath = "//*[text()='Address is required.'" +
            " or text()='Полето за адрес е задължително.']")
    private WebElement addressFieldAllErrorMsg;

    @FindBy(xpath = "//*[text()='Postal code is required.'" +
            " or text()='Полето за пощенски код е задължително.']")
    private WebElement postCodeFieldAllErrorMsg;

    @FindBy(xpath = "//*[text()='The phone field is required.'" +
            " or text()='The Phone must be at least 10 characters.'" +
            " or text()='The Phone format is invalid.'" +
            " or text()='Полето за телефон е задължително.'" +
            " or text()='Полето Телефон трябва да бъде минимум 10 знака.'" +
            " or text()='Полето Телефон е в невалиден формат.']")
    private WebElement phoneFieldAllErrorMsg;

    @FindBy(xpath = "//*[text()='You must accept the Terms and Privacy Policy.'" +
            " or text()='Полето за Общи Условия и Политика на Поверителност е задължително.']")
    private WebElement termsCheckboxAllErrorMsg;

    @FindBy(css = ".select2-results__option.select2-results__option--highlighted\n")
    private WebElement afghanistanFromCountryDropdown;

    // Methods i.e. actions on the page
    // This method fill in all input fields in registration page
    public RegistrationPage fillInInputFields(String firstAndLastName, String email, String password,
                                              String confirmationPassword, String city, String address,
                                              String postCode, String phone) {

        enterData(firstAndLastNameInput, firstAndLastName);
        enterData(emailInput, email);
        enterData(passwordInput, password);
        enterData(confirmationPasswordInput, confirmationPassword);
        enterData(cityInput, city);
        enterData(addressInput, address);
        enterData(postCodeInput, postCode);
        enterData(phoneInput, phone);

        return this;
    }

    // This method submit the registration form
    public RegistrationPage submitRegistrationForm(){

        js.executeScript("arguments[0].scrollIntoView();",registerBtn);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(registerBtn));

        registerBtn.click();
        return this;
    }

    //This method check if all error messages are visible on the page
    public boolean checkAllFieldsErrorMsg() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        WebElement[] allErrorMsg = { fullNameFieldAllErrorMsg, emailFieldAllErrorMsg, passwordFieldAllErrorMsg,
                confirmationPasswordFieldAllErrorMsg, countryDropdownAllErrorMsg, cityFieldAllErrorMsg,
                addressFieldAllErrorMsg, postCodeFieldAllErrorMsg, phoneFieldAllErrorMsg, termsCheckboxAllErrorMsg };

        try {
            for (WebElement errorMsg : allErrorMsg) {
                if (!errorMsg.isDisplayed()) {
                    js.executeScript("arguments[0].scrollIntoView();", errorMsg);
                }

                wait.until(ExpectedConditions.visibilityOf(errorMsg));
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error: Error message is not visible on this page!" + e.getMessage());
            return false;
        }
    }

    // This method fill in all fields in registration page
    public RegistrationPage fillInAllRegistrationFields(String firstAndLastName, String email, String password,
                                              String confirmationPassword, String city, String address,
                                              String postCode, String phone) {

        String currentDateTime = BasePage.getCurrentDateAndTime();

        enterData(firstAndLastNameInput, firstAndLastName);
        enterData(emailInput, email + "_" + currentDateTime + "@eurocoders.org");
        enterData(passwordInput, password);
        enterData(confirmationPasswordInput, confirmationPassword);
        enterData(cityInput, city);
        enterData(addressInput, address);
        enterData(postCodeInput, postCode);
        enterData(phoneInput, phone);

        countryDropdown.click();
        afghanistanFromCountryDropdown.click();
        termsCheckbox.click();

        return this;


        // да пробвам дали ако използвам горния метод и тук само добавя имейла няма да изтрие вече въведения и да го въведе правилно


    }
}