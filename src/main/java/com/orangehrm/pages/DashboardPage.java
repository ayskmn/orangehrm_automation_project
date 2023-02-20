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


    @FindBy(xpath = "//button[@type='button']/i[1]")
    private WebElement expandBtn;

    @FindBy(xpath = "//p[normalize-space()='My Actions']")
    private WebElement myActionsSign;

    @FindBy(xpath = "//p[contains(.,'Leave Requests to Approve')]")
    private WebElement leaveRequestsLink;

    @FindBy(xpath = "//input[@placeholder='yyyy-mm-dd'][1]")
    private WebElement dateInput;

    public void clickExpandBtn() {
        expandBtn.click();
    }

    public void verifyMyActionsSign() {
        Assert.assertTrue(myActionsSign.isDisplayed());
        leaveRequestsLink.click();
    }

    public void filloutLeaveList() throws InterruptedException {

        localDate = LocalDateTime.now();
        dateformatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        Thread.sleep(2000);
        dateInput.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(2000);
        dateInput.sendKeys(dateformatter.format(localDate));
        Thread.sleep(2000);
    }
}

    class Dummy{
        public static void main(String[] args) {
            LocalDateTime localDate = LocalDateTime.now();
            // DateTimeFormatter class used to format and
            // parse date and time. ofPattern() is a method
            // used with DateTimeFormatter to format and
            // parse date and time.
            DateTimeFormatter dateformatter
                    = DateTimeFormatter.ofPattern("YYYY-MM-dd");
            // display the date
            System.out.println(dateformatter.format(localDate));
            System.out.println();

        }



}
