package com.swaglabs.pages;

import com.swaglabs.drivers.GUIDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P5_OverviewPage {

    private GUIDriver driver;
    public P4_CheckoutPage checkout;
    public P2_ProductsPage products;
    public P5_OverviewPage(GUIDriver driver) {
        this.driver = driver;
        this.checkout = new P4_CheckoutPage(driver);
        this.products = new P2_ProductsPage(driver);
    }

    private final By FinishOrder = By.id("finish");
    private final By CancelOrder = By.id("cancel");
    private final By PaymentCode = By.cssSelector("[data-test='payment-info-value']");
    private final By ShipInfo = By.cssSelector("[data-test='shipping-info-value']");

    @Step("Cancel Order and Back to products page")
    public P2_ProductsPage CancelOrder() {
        driver.element().click(CancelOrder);
        return new P2_ProductsPage(driver);
    }
    @Step("Finish Order")
    public P6_CompletePage FinishOrder() {
        driver.element().click(FinishOrder);
        return new P6_CompletePage(driver);
    }

    //Validation
    @Step("Get Payment Information {expectedInfo}")
    public P5_OverviewPage verifyPaymentInformation(String expectedInfo)
    {
        String actualInfo = driver.element().getText(PaymentCode);
        driver.validation().Equals(actualInfo, expectedInfo , "Payment information does not match. Expected: " + expectedInfo + ", Actual: " + actualInfo);
    return this;
    }
    @Step("Get Shipping Information {expectedInfo}")
    public P5_OverviewPage verifyShippingInformation(String expectedInfo)
    {
        String actualInfo = driver.element().getText(ShipInfo);
        driver.validation().Equals(actualInfo, expectedInfo , "Shipping information does not match. Expected: " + expectedInfo + ", Actual: " + actualInfo);
        return this;
    }
    @Step("Verify product number in cart is {expectedNumber}")
    public P5_OverviewPage verifyProductNumber(String expectedNumber) {
        products.verifyProductNumber(expectedNumber);
        return this;
    }
    @Step("Verify Backpack price is {expectedPrice}")
    public P5_OverviewPage verifyBackpackProductPrice(String expectedPrice)
    {
        products.verifyBackpackPrice(expectedPrice);
        return this;
    }
    @Step("Verify BikeLight price is {expectedPrice}")
    public P5_OverviewPage verifyBikeLightProductPrice(String expectedPrice)
    {
        products.verifyBikeLightPrice(expectedPrice);
        return this;
    }
    @Step("Verify BoltTShirt price is {expectedPrice}")
    public P5_OverviewPage verifyBoltTShirtProductPrice(String expectedPrice)
    {
        products.verifyBoltTShirtPrice(expectedPrice);
        return this;
    }
    @Step("Verify FleeceJacket price is {expectedPrice}")
    public P5_OverviewPage verifyFleeceJacketProductPrice(String expectedPrice)
    {
        products.verifyFleeceJacketPrice(expectedPrice);
        return this;
    }
    @Step("Verify Onesie price is {expectedPrice}")
    public P5_OverviewPage verifyOnesieProductPrice(String expectedPrice)
    {
        products.verifyOnesiePrice(expectedPrice);
        return this;
    }
    @Step("Verify RedShirt price is {expectedPrice}")
    public P5_OverviewPage verifyRedShirtProductPrice(String expectedPrice)
    {
        products.verifyRedShirtPrice(expectedPrice);
        return this;
    }

    @Step("Verify Cart Page URL {expectedURL}")
    public P5_OverviewPage verifyCompletePageURL(String expectedURL)
    {
        products.verifyCurrentUrl(expectedURL);
        return this;
    }


}
