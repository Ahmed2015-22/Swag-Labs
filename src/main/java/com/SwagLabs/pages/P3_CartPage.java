package com.swaglabs.pages;

import com.swaglabs.drivers.GUIDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P3_CartPage {
    private GUIDriver driver;
    public P2_ProductsPage products;
    public P3_CartPage(GUIDriver driver) {

        this.driver = driver;
        this.products =  new P2_ProductsPage(driver);
    }

    private final By ContinueShoppingButton = By.id("continue-shopping");
    private final By CheckoutButton = By.id("checkout");




    @Step("Remove Backpack from cart")
    public P3_CartPage removeBackpackFromCart() {
        products.removeBackpack();
        return this;
    }
    @Step("Remove BikeLight from cart")
    public P3_CartPage removeBikeLightFromCart() {
        products.removeBikeLight();
        return this;
    }
    @Step("Remove BoltTShirt from cart")
    public P3_CartPage removeBoltTShirtFromCart() {
        products.removeBoltTShirt();
        return this;
    }
    @Step("Remove FleeceJacket from cart")
    public P3_CartPage removeFleeceJacketFromCart() {
        products.removeFleeceJacket();
        return this;
    }
    @Step("Remove Onesie from cart")
    public P3_CartPage removeOnesieFromCart() {
        products.removeOnesie();
        return this;
    }
    @Step("Remove RedShirt from cart")
    public P3_CartPage removeRedShirtCart() {
        products.removeRedShirt();
        return this;
    }
    @Step("Back to Products Page")
    public P2_ProductsPage backToProductsPage()
    {
        driver.element().click(ContinueShoppingButton);
        return new P2_ProductsPage(driver);
    }
    @Step("Navigate to Checkout Page")
    public P4_CheckoutPage  checkoutPage()
    {
        driver.element().click(CheckoutButton);
        return new P4_CheckoutPage(driver);
    }

    //Validations
    @Step("Verify product number in cart is {expectedNumber}")
    public P3_CartPage verifyProductNumber(String expectedNumber) {
        products.verifyProductNumber(expectedNumber);
        return this;
    }
    @Step("Verify Backpack price is {expectedPrice}")
    public P3_CartPage verifyBackpackProductPrice(String expectedPrice)
    {
        products.verifyBackpackPrice(expectedPrice);
        return this;
    }
    @Step("Verify BikeLight price is {expectedPrice}")
    public P3_CartPage verifyBikeLightProductPrice(String expectedPrice)
    {
        products.verifyBikeLightPrice(expectedPrice);
        return this;
    }
    @Step("Verify BoltTShirt price is {expectedPrice}")
    public P3_CartPage verifyBoltTShirtProductPrice(String expectedPrice)
    {
        products.verifyBoltTShirtPrice(expectedPrice);
        return this;
    }
    @Step("Verify FleeceJacket price is {expectedPrice}")
    public P3_CartPage verifyFleeceJacketProductPrice(String expectedPrice)
    {
        products.verifyFleeceJacketPrice(expectedPrice);
        return this;
    }
    @Step("Verify Onesie price is {expectedPrice}")
    public P3_CartPage verifyOnesieProductPrice(String expectedPrice)
    {
        products.verifyOnesiePrice(expectedPrice);
        return this;
    }
    @Step("Verify RedShirt price is {expectedPrice}")
    public P3_CartPage verifyRedShirtProductPrice(String expectedPrice)
    {
        products.verifyRedShirtPrice(expectedPrice);
        return this;
    }

    @Step("Verify Cart Page URL {expectedURL}")
    public P3_CartPage verifyCartPage(String expectedURL)
    {
        products.verifyCurrentUrl(expectedURL);
        return this;
    }



}
