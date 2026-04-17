package com.swaglabs.pages;

import com.swaglabs.drivers.GUIDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P6_CompletePage {


    private GUIDriver driver;
    public P5_OverviewPage overview;
    public P2_ProductsPage products;
    public P6_CompletePage(GUIDriver driver) {
        this.driver = driver;
        this.overview = new P5_OverviewPage(driver);
        this.products = new P2_ProductsPage(driver);
    }

    private final By CompleteMessage = By.cssSelector("[data-test='complete-header']");
    private final By BackHome = By.id("back-to-products");

    @Step("Click on Back to home")
    public P2_ProductsPage clickOnBackToHome()
    {
        driver.element().click(BackHome);
        return new P2_ProductsPage(driver);
    }

    //Validations
    @Step("Verify to Back to Products page after Confirming Order {expectedURL}")
    public P6_CompletePage verifyBackToHome(String expectedURL) {
        products.verifyCurrentUrl(expectedURL);
        return this;
    }
    @Step("Verify Success Message {expectedMessage}")
    public P6_CompletePage verifySuccessMessage(String expectedMessage)
    {
        String actualMSG = driver.element().getText(CompleteMessage);
        driver.validation().Equals(actualMSG, expectedMessage , "Success message does not match. Expected: " + expectedMessage + ", Actual: " + actualMSG);
        return this;
    }

}
