package com.orangehrm;

import com.orangehrm.pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTestPositive() throws InterruptedException {
        extentTest = reports.startTest("OrangeHRM login positive test");
        LoginPage loginPage = new LoginPage(driver);
        extentTest.log(LogStatus.INFO, "Created login page");
        loginPage.navigateToLoginPage();
        extentTest.log(LogStatus.INFO, "Navigated to login page");
        Thread.sleep(2000);
        loginPage.login();
        Thread.sleep(3000);
        extentTest.log(LogStatus.PASS, "Was able to log in with valid credentials");

    }
}
