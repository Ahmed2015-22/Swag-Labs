package com.swaglabs.pages;

import com.swaglabs.drivers.GUIDriver;
import com.swaglabs.utils.dataReader.PropertyReader;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P1_LoginPage {
    private GUIDriver driver;
    public P1_LoginPage(GUIDriver driver) {
        this.driver = driver;
    }

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");

    @Step("Navigate to Home Page")
    public P1_LoginPage navigate() {
        driver.browser().navigateTo(PropertyReader.getProperty("baseUrlWeb"));
        return this;
    }
    @Step("Enter username {username}")
    public P1_LoginPage enterUsername(String username) {
        driver.element().type(usernameInput, username);
        return this;
    }
    @Step("Enter password {password}")
    public P1_LoginPage enterPassword(String password) {
        driver.element().type(passwordInput, password);
        return this;
    }
    @Step("Click login button")
    public P2_ProductsPage clickLoginButton() {
        driver.element().click(loginButton);
        return new P2_ProductsPage(driver);
    }

    //Validations
    @Step("Verify login error message with Invalid Login {errorExpected}")
    public P1_LoginPage verifyLoginErrorMsg (String errorExpected)
    {
        String errorActual = driver.element().getText(errorMessage);
        driver.verification().Equals(errorActual,errorExpected, "Login error message is not as expected");
        return this;
    }

    //@Step("Verify login error message with Invalid Login {errorExpected}")
    //public P1_LoginPage

    @Step("Verify current URL is {expectedUrl}")
    public P1_LoginPage verifyCurrentUrl (String expectedUrl) {
        String actualUrl = driver.browser().getCurrentUrl();
        driver.verification().Equals(actualUrl, expectedUrl, "Current URL is Correct");
        return this;
    }
}
