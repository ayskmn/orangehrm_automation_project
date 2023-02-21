package com.orangehrm;

import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest{

    @Test
    public void DashboardTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        extentTest = reports.startTest("OrangeHRM dashboard test");
        loginPage.navigateToLoginPage();
        extentTest.log(LogStatus.INFO, "Navigated to login page");
        loginPage.login();
        extentTest.log(LogStatus.PASS, "Was able to log in with valid credentials");
        dashboardPage.clickExpandBtn();
        extentTest.log(LogStatus.PASS, "Was able to expand menu");
        extentTest.log(LogStatus.FAIL, "Couldn't expand menu");
        dashboardPage.verifyMyActionsSign();
        dashboardPage.findQuantityOfLeaveRequests();
    }
}
