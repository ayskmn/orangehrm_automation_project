package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.ObjectInputFilter;

import static com.orangehrm.config.ConfigReader.getProperty;

public class LoginPage extends BasePage {
    public LoginPage (WebDriver driver){
        super(driver);
    }

    @FindBy (name = "username")
    private WebElement usernameInput;

    @FindBy (name = "password")
    private WebElement passwordInput;

    @FindBy (xpath = "//button[@type='submit']")
    private WebElement loginBtn;

    @FindBy (tagName = "h6")
    private WebElement dashboardSign;

    public void navigateToLoginPage(){
        driver.get(getProperty("url"));
        Assert.assertTrue(driver.getTitle().equals("OrangeHRM"));
    }

    public void login(){
        usernameInput.sendKeys(getProperty("username"));
        passwordInput.sendKeys(getProperty("password"));
        Assert.assertTrue(loginBtn.isEnabled());
        loginBtn.click();
        Assert.assertTrue(dashboardSign.isDisplayed());
    }
}
