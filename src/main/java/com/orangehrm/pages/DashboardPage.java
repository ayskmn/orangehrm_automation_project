package com.orangehrm.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    LocalDateTime localDate;
    DateTimeFormatter dateformatter;


    @FindBy(xpath = "//button[contains(@class,'oxd-main-menu-button')]")
    private WebElement expandBtn;

    @FindBy(xpath = "//p[normalize-space()='My Actions']")
    private WebElement myActionsSign;

    @FindBy(xpath = "//div[@class='orangehrm-todo-list-item']/p[contains(.,'Leave')]")
    private WebElement leaveRequestsLink;

    @FindBy(xpath = "//input[@placeholder='yyyy-mm-dd'][1]")
    private WebElement dateInput;

    @FindBy(xpath = "(//button[contains(., 'Approve')])[1]")
    private WebElement approveBtn;

    @FindBy(xpath = "//a[@class='oxd-main-menu-item']/span[text()='Dashboard']")
    private WebElement dashboardLink;

    public void clickExpandBtn() {
        expandBtn.click();
//        Assert.assertTrue(!expandBtn.isEnabled(),"Expand button is enabled");
    }

    public void verifyMyActionsSign() {
        Assert.assertTrue(myActionsSign.isDisplayed());
    }

    public void findQuantityOfLeaveRequests() throws InterruptedException {
        String leaveRequestsQuantity = leaveRequestsLink.getText().trim();
        int numberOfRequestsBefore = Integer.parseInt((leaveRequestsQuantity.replaceAll("[a-zA-Z()]", "").trim()));
        Thread.sleep(2000);
        leaveRequestsLink.click();
        Thread.sleep(2000);
        approveBtn.click();
        dashboardLink.click();
        int numberOfRequestsAfter = Integer.parseInt((leaveRequestsQuantity.replaceAll("[a-zA-Z()]", "").trim()));
        Assert.assertEquals(numberOfRequestsBefore,numberOfRequestsAfter);

    }
}








