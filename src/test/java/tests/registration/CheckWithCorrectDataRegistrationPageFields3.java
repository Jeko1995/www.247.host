package tests.registration;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.VerifyEmailPage;

public class CheckWithCorrectDataRegistrationPageFields3 extends TestUtil {

    // Test that check all fields positive validation on registration page
    @Test(dataProvider = "correctRegistrationCredentials")
    public void checkWithCorrectDataRegistrationPageFields3(String firstAndLastName, String email, String password,
                                                            String confirmationPassword,
                                                            String city, String address, String postCode, String phone) {

        // Open registration page, enter data and submit form
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginBtn().clickCreateNewAccountBtn()
                .fillInInputFields(firstAndLastName, email, password, confirmationPassword, city, address, postCode, phone)
                .enterUniqueEmail(email).fillInDropdownFieldAndCheckbox().clickSubmitBtn();

        VerifyEmailPage verifyEmailPage = new VerifyEmailPage(driver);

        // Assert that the user is successfully register.
        Assert.assertTrue(verifyEmailPage.isAtVerifyEmailPage());
    }
}