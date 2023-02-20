package com.orangehrm;

import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.LoginPage;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest{

    @Test
    public void DashboardTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        loginPage.navigateToLoginPage();
        loginPage.login();
        dashboardPage.clickExpandBtn();
        dashboardPage.verifyMyActionsSign();
        dashboardPage.filloutLeaveList();
    }
}
