package com.swaglabs.pages;

import com.swaglabs.drivers.GUIDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P2_ProductsPage {
    private GUIDriver driver;
    public P1_LoginPage login;
    public P2_ProductsPage(GUIDriver driver) {
        this.driver = driver;
        this.login = new P1_LoginPage(driver);

    }

    private final By menuButton = By.id("react-burger-menu-btn");
    private final By logoutLink = By.id("logout_sidebar_link");
    private final By pageTitle = By.className("title");
    private final By aboutPage = By.id("about_sidebar_link");
    private final By shoppingCartBadge = By.id("shopping_cart_container");
    private final By productNumber = By.className("shopping_cart_badge");
    private final By copyRight = By.cssSelector("[data-test='footer-copy']");

    private final By AddBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By AddBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private final By AddBoltTShirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private final By AddFleeceJacket = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private final By AddOnesie = By.id("add-to-cart-sauce-labs-onesie");
    private final By AddRedShirt = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");

    private final By RemoveBackpack = By.id("remove-sauce-labs-backpack");
    private final By RemoveBikeLight = By.id("remove-sauce-labs-bike-light");
    private final By RemoveBoltTShirt = By.id("remove-sauce-labs-bolt-t-shirt");
    private final By RemoveFleeceJacket = By.id("remove-sauce-labs-fleece-jacket");
    private final By RemoveOnesie = By.id("remove-sauce-labs-onesie");
    private final By RemoveRedShirt = By.id("remove-test.allthethings()-t-shirt-(red)");

    private final By BackpackPrice = By.xpath("//div[@data-test='inventory-item-price' and text()='29.99']");
    private final By BikeLightPrice = By.xpath("//div[@data-test='inventory-item-price' and text()='9.99']");
    private final By BoltTShirtPrice = By.xpath("//div[@data-test='inventory-item-price' and text()='15.99']");
    private final By FleeceJacketPrice = By.xpath("//div[@data-test='inventory-item-price' and text()='49.99']");
    private final By OnesiePrice = By.xpath("//div[@data-test='inventory-item-price' and text()='7.99']");
    private final By RedShirtPrice = By.xpath("//div[@data-test='inventory-item-price' and text()='15.99']");

    private final By Sorting = By.cssSelector("[data-test='product-sort-container']");

    private final By linkedin = By.className("social_linkedin");
    private final By twitter = By.className("social_twitter");
    private final By facebook = By.className("social_facebook");

    //Actions
    @Step("Click menu button")
    public P2_ProductsPage clickMenuButton() {
        driver.element().click(menuButton);
        return this;
    }
    @Step("Click logout link")
    public P2_ProductsPage clickLogoutLink() {
        driver.element().click(logoutLink);
        return this;
    }

    @Step("Add product one to cart")
    public P2_ProductsPage addBackpack() {
        driver.element().click(AddBackpack);
        return this;
    }
    @Step("Add product two to cart")
    public P2_ProductsPage addBikeLight() {
        driver.element().click(AddBikeLight);
        return this;
    }
    @Step("Add product three to cart")
    public P2_ProductsPage addBoltTShirt() {
        driver.element().click(AddBoltTShirt);
        return this;
    }
    @Step("Add product four to cart")
    public P2_ProductsPage addFleeceJacket() {
        driver.element().click(AddFleeceJacket);
        return this;
    }
    @Step("Add product five to cart")
    public P2_ProductsPage addOnesie() {
        driver.element().click(AddOnesie);
        return this;
    }
    @Step("Add product six to cart")
    public P2_ProductsPage addRedShirt() {
        driver.element().click(AddRedShirt);
        return this;
    }
    @Step("Remove product one from cart")
    public P2_ProductsPage removeBackpack() {
        driver.element().click(RemoveBackpack);
        return this;
    }
    @Step("Remove product Two from cart")
    public P2_ProductsPage removeBikeLight() {
        driver.element().click(RemoveBikeLight);
        return this;
    }
    @Step("Remove product Three from cart")
    public P2_ProductsPage removeBoltTShirt() {
        driver.element().click(RemoveBoltTShirt);
        return this;
    }
    @Step("Remove product Four from cart")
    public P2_ProductsPage removeFleeceJacket() {
        driver.element().click(RemoveFleeceJacket);
        return this;
    }
    @Step("Remove product Five from cart")
    public P2_ProductsPage removeOnesie() {
        driver.element().click(RemoveOnesie);
        return this;
    }
    @Step("Remove product Six from cart")
    public P2_ProductsPage removeRedShirt() {
        driver.element().click(RemoveRedShirt);
        return this;
    }
    @Step("Navigate to About page")
    public P2_ProductsPage clickAboutLink() {
        driver.element().click(aboutPage);
        return this;
    }
    @Step("Sort products by {option}")
    public P2_ProductsPage sortProductsBy(String option) {
        driver.element().selectFromDropdown(Sorting, option);
        return this;
    }
    @Step("Navigate to Twitter")
    public P2_ProductsPage navigateToTwitter() {
        driver.element().click(twitter);
        driver.browser().switchToNewWindow();
        return this;
    }
    @Step("Navigate to LinkedIn")
    public P2_ProductsPage navigateToLinkedIn() {
        driver.element().click(linkedin);
        driver.browser().switchToNewWindow();
        return this;
    }
    @Step("Navigate to Facebook")
    public P2_ProductsPage navigateToFacebook() {
        driver.element().click(facebook);
        driver.browser().switchToNewWindow();
        return this;
    }
    @Step("Login With Username {username} and Password {password}")
    public P1_LoginPage loginWithUsernameAndPassword(String username, String password)
    {
        login.enterPassword(password);
        login.enterUsername(username);
        login.clickLoginButton();
        return new P1_LoginPage(driver);
    }

    @Step("Click shopping cart badge")
    public P3_CartPage clickShoppingCartBadge() {
        driver.element().click(shoppingCartBadge);
        return new P3_CartPage(driver);
    }




    //Validations
    /*public LandingPage verifyPageTitle(String expectedTitle) {
        String actualTitle = getPageTitle();
        driver.verification().Equals(actualTitle, expectedTitle, "Page title is not as expected");
        return this;
    }  */
    @Step("Verify product number in cart is {expectedNumber}")
    public P2_ProductsPage verifyProductNumber(String expectedNumber) {
        String actualNumber = driver.element().getText(productNumber);
        driver.verification().Equals(actualNumber, expectedNumber, "Product number in cart is not as expected");
        return this;
    }
    @Step("Verify Backpack price is {expectedPrice}")
    public P2_ProductsPage verifyBackpackPrice(String expectedPrice) {
        String actualPrice = driver.element().getText(BackpackPrice);
        driver.verification().Equals(actualPrice, expectedPrice, "Product One price is not as expected");
        return this;
    }
    @Step("Verify BikeLight price is {expectedPrice}")
    public P2_ProductsPage verifyBikeLightPrice(String expectedPrice) {
        String actualPrice = driver.element().getText(BikeLightPrice);
        driver.verification().Equals(actualPrice, expectedPrice, "Product Two price is not as expected");
        return this;
    }
    @Step("Verify BoltTShirt price is {expectedPrice}")
    public P2_ProductsPage verifyBoltTShirtPrice(String expectedPrice) {
        String actualPrice = driver.element().getText(BoltTShirtPrice);
        driver.verification().Equals(actualPrice, expectedPrice, "Product Three price is not as expected");
        return this;
    }
    @Step("Verify FleeceJacket price is {expectedPrice}")
    public P2_ProductsPage verifyFleeceJacketPrice(String expectedPrice) {
        String actualPrice = driver.element().getText(FleeceJacketPrice);
        driver.verification().Equals(actualPrice, expectedPrice, "Product Four price is not as expected");
        return this;
    }
    @Step("Verify Onesie price is {expectedPrice}")
    public P2_ProductsPage verifyOnesiePrice(String expectedPrice) {
        String actualPrice = driver.element().getText(OnesiePrice);
        driver.verification().Equals(actualPrice, expectedPrice, "Product Five price is not as expected");
        return this;
    }
    @Step("Verify RedShirt price is {expectedPrice}")
    public P2_ProductsPage verifyRedShirtPrice(String expectedPrice) {
        String actualPrice = driver.element().getText(RedShirtPrice);
        driver.verification().Equals(actualPrice, expectedPrice, "Product Six price is not as expected");
        return this;
    }

    @Step("Verify Sorting Products {expectedSort}")
    public P2_ProductsPage verifySortProducts(String expectedSort)
    {
        String actualSort = driver.element().getText(Sorting);
        driver.verification().Equals(actualSort, expectedSort, "Sorting Products is not as expected");
        return this;
    }
    @Step("Verify current URL is {expectedUrl}")
    public P2_ProductsPage verifyCurrentUrl (String expectedUrl) {
        String actualUrl = driver.browser().getCurrentUrl();
        driver.verification().Equals(actualUrl, expectedUrl, "Current URL is Correct");
        return this;
    }
    @Step("Verify copyright text is {expectedText}")
    public P2_ProductsPage verifyCopyRightText(String expectedText) {
        String actualText = driver.element().getText(copyRight);
        driver.verification().Equals(actualText, expectedText, "Copyright text is not as expected");
        return this;
    }



}
