package tests.login;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ResetPasswordPage;

public class CheckForgottenPass19 extends TestUtil {

    //This test check is option for forgotten password works correctly
    @Test(dataProvider = "getEmailAndEmailLoginCredentials")
    public void checkForgottenPass19( String username, String email, String password) {

        // Go to the reset password page and check is option for forgotten password works correctly
        HomePage homePage = new HomePage(driver);
        ResetPasswordPage resetPasswordPage = homePage.clickLoginBtn().clickForgottenPasswordLink()
                .enterEmailAndSubmit(username);

        Assert.assertTrue(resetPasswordPage.checkConfirmationMsg());

    }
}