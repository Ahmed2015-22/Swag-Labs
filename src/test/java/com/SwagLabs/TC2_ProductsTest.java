package com.swaglabs;

import com.swaglabs.drivers.GUIDriver;
import com.swaglabs.pages.P1_LoginPage;
import com.swaglabs.utils.TimeManager;
import com.swaglabs.utils.dataReader.JsonReader;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


@Epic("Swag Labs")
@Feature("UI User Management")
@Story("Products Landing Page")
@Severity(SeverityLevel.CRITICAL)
@Owner("Tal3at")

public class TC2_ProductsTest extends BaseTest {

    @Tag("Products")
    @Description("Change Sorting By Descending Price and Checking the First Product Price")
    @TmsLink("TC_01")
    @Test(priority = 1)
    public void changeSortingHtL()
    {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton()
                .sortProductsBy(productsData.getJsonData("Sorting.DescPrice"))
                .verifyFleeceJacketPrice(productsData.getJsonData("Price.fleeceJacket"));
    }
    @Tag("Products")
    @Description("Change Sorting By Ascending Price and Checking the First Product Price")
    @TmsLink("TC_02")
    @Test(priority = 2)
    public void changeSortingLtH()
    {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton()
                .sortProductsBy(productsData.getJsonData("Sorting.ASCPrice"))
                .verifyOnesiePrice(productsData.getJsonData("Price.onesie"));
    }
    @Tag("Products")
    @Description("Adding products to cart then Logout")
    @Test(priority = 3)
    public void addToCartThenLogout()
    {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton()
                .addBackpack()
                .addRedShirt()
                .clickMenuButton()
                .clickLogoutLink()
                .verifyCurrentUrl(productsData.getJsonData("logoutLink"));
    }

    @Tag("Products")
    @Description("Navigate to about page")
    @Test(priority = 4)
    public void navigateToAboutPage() {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton()
                .clickMenuButton()
                .clickAboutLink()
                .verifyCurrentUrl(productsData.getJsonData("aboutLink"));
    }
    @Tag("Products")
    @Description("Finding Copy Rights Year")
    @Test(priority = 5)
    public void findCopyRightsYear() {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton()
                .verifyCopyRightText(productsData.getJsonData("copyRightText"));
    }
    @Tag("Products")
    @Description("Navigate to X page")
    @Test(priority = 6)
    public void navigateToTwitterPage()
    {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton()
                .navigateToTwitter()
                .verifyCurrentUrl(productsData.getJsonData("socialMediaLinks.twitter"));
    }

    @Tag("Products")
    @Description("Navigate to Facebook page")
    @Test(priority = 7)
    public void navigateToFacebookPage()
    {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton()
                .navigateToFacebook()
                .verifyCurrentUrl(productsData.getJsonData("socialMediaLinks.facebook"));
    }
    @Tag("Products")
    @Description("Navigate to Linkedin page")
    @Test(priority = 8)
    public void navigateToLinkedinPage()
    {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton()
                .navigateToLinkedIn()
                .verifyCurrentUrl(productsData.getJsonData("socialMediaLinks.linkedIn"));
    }
    @Tag("Products")
    @Description("Add All Products")
    @Test(priority = 9)
    public void addAllProducts()
    {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton().addBackpack()
                .addOnesie().addRedShirt()
                .addFleeceJacket().addBoltTShirt()
                .addBikeLight()
                .verifyProductNumber("6");
    }
    @Tag("Products")
    @Description("Add and remove products")
    @Test(priority = 10)
    public void addRemoveProducts()
    {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton().addBackpack()
                .addOnesie().addRedShirt()
                .addFleeceJacket().addBoltTShirt()
                .removeBackpack().removeRedShirt()
                .verifyProductNumber("3");
    }
    @Tag("Products")
    @Description("Add top 3 products")
    @Test(priority = 11)
    public void addTop3Products()
    {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton().addBackpack()
                .addFleeceJacket().addBoltTShirt()
                .verifyProductNumber("3");
    }
    @Tag("Products")
    @Description("Add Less 3 products")
    @Test(priority = 12)
    public void addLess3Products()
    {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton()
                .addOnesie().addBikeLight()
                .addRedShirt()
                .verifyProductNumber("3");
    }
    @Tag("Products")
    @Description("Adding products to cart then Logout then Login")
    @Test(priority = 13)
    public void addToCartThenLogoutThenLogin()
    {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton()
                .addBackpack()
                .addRedShirt()
                .clickMenuButton()
                .clickLogoutLink()
                .loginWithUsernameAndPassword(loginData.getJsonData("usernames"), loginData.getJsonData("password"))
                .verifyCurrentUrl(loginData.getJsonData("landingPageUrl"));
    }

    @Tag("Products")
    @Description("Adding Products then Navigate to Cart Page")
    @Test(priority = 14)
    public void addProductsThenNavigateToCartPage()
    {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton()
                .addBikeLight().addOnesie()
                .addBackpack().addFleeceJacket()
                .clickShoppingCartBadge()
                .verifyCartPage(productsData.getJsonData("cartLink"));

    }


    @BeforeClass
    protected void preCondition() {

        loginData = new JsonReader("login-data");
        productsData = new JsonReader("product-data");
    }
    @BeforeMethod
    public void setUp() {
        driver = new GUIDriver();
        new P1_LoginPage(driver).navigate();
    }

    @AfterMethod
    public void tearDown() {
        driver.quitDriver();
    }
}
