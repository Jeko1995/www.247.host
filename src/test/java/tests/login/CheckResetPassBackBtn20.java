package tests.login;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class CheckResetPassBackBtn20 extends TestUtil {

    // Test for checking if back button on the reset password page working
   @Test()
    public void checkResetPassBackBtn20 () {

       // Go to the reset password page and click back button
       HomePage homePage = new HomePage(driver);
       LoginPage loginPage = homePage.clickLoginBtn().clickForgottenPasswordLink().clickBackBtn();

        // Assert that back button is working
       Assert.assertTrue(loginPage.isAt());
    }
}