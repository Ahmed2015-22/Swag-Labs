package com.swaglabs.pages;

import com.swaglabs.drivers.GUIDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P4_CheckoutPage {
    private GUIDriver driver;
    public P3_CartPage cart;
    public P4_CheckoutPage(GUIDriver driver) {
        this.driver = driver;
        this.cart = new P3_CartPage(driver);
    }

    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By zipCode = By.id("postal-code");
    private final By Continue = By.id("continue");
    private final By Cancel = By.id("cancel");

    private final By error = By.cssSelector("[data-test = 'error']");

    @Step("Enter First Name {firstName}")
    public P4_CheckoutPage enterFirstName(String firstName)
    {
        driver.element().type(firstNameInput, firstName);
        return this;
    }
    @Step("Enter Last Name {lastName}")
    public P4_CheckoutPage enterLastName(String lastName)
    {
        driver.element().type(lastNameInput, lastName);
        return this;
    }
    @Step("Enter Zip Code {ZipCode}")
    public P4_CheckoutPage enterZipCode(String ZipCode)
    {
        driver.element().type(zipCode, ZipCode);
        return this;
    }

    @Step("Continue To Overview Page")
    public P5_OverviewPage  clickContinue()
    {
        driver.element().click(Continue);
        return new  P5_OverviewPage(driver);
    }

    @Step("Back To Cart Page")
    public P3_CartPage clickCancel()
    {
        driver.element().click(Cancel);
        return new  P3_CartPage(driver);
    }


    //Validation
    @Step("Check Error Massage {expectedMsg}")
    public P4_CheckoutPage errorMassage(String expectedMsg)
    {
        String actualMsg = driver.element().getText(error);
        driver.verification().Equals(actualMsg, expectedMsg , "Error Massage is not As Expected");
        return this;
    }
    @Step("Check OverView Page URL {expectedURL}")
    public P4_CheckoutPage verifyOverViewLink (String expectedURL)
    {
        cart.verifyCartPage(expectedURL);
        return this;
    }
}
