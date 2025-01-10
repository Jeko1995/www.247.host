package tests.registration;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

public class CheckRegistrationPageFieldsWithInvalidData47 extends TestUtil {

    // Test that check all fields negative validation on registration page
    @Test(dataProvider = "invalidRegistrationCredentials")
    public void registrationPageFieldsValidation47(String firstAndLastName, String email, String password,
                                                   String confirmationPassword,
                                                   String city, String address, String postCode, String phone) {

        // Open registration page, enter data and submit form
        HomePage homePage = new HomePage(driver);
        RegistrationPage registrationPage = homePage.clickLoginBtn().clickCreateNewAccountBtn()
                .fillInInputFields(firstAndLastName, email, password, confirmationPassword, city, address, postCode, phone)
                .submitRegistrationForm();

        // Assert that all error messages are displayed and user is not finish his registration
        Assert.assertTrue(registrationPage.checkAllFieldsErrorMsg());
    }
}
