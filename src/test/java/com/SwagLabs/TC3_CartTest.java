package com.swaglabs;

import com.swaglabs.drivers.GUIDriver;
import com.swaglabs.pages.P1_LoginPage;
import com.swaglabs.utils.dataReader.JsonReader;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Swag Labs")
@Feature("UI User Management")
@Story("Cart Page")
@Severity(SeverityLevel.CRITICAL)
@Owner("Tal3at")

public class TC3_CartTest extends BaseTest{

    @Tag("Cart")
    @Description("Adding All products to cart")
    @TmsLink("TC_01")
    @Test(priority = 1)
    public void addAllProductsToCart()
    {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton()
                .addBackpack().addBikeLight()
                .addBoltTShirt().addFleeceJacket()
                .addOnesie().addRedShirt()
                .clickShoppingCartBadge()
                .verifyProductNumber("6");
    }
    @Tag("Cart")
    @Description("Adding All products to cart then remove them ")
    @TmsLink("TC_02")
    @Test(priority = 2)
    public void addAllProductsToCartThenRemoveThem()
    {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton()
                .addBackpack().addBikeLight()
                .addBoltTShirt().addFleeceJacket()
                .addOnesie().addRedShirt()
                .clickShoppingCartBadge()
                .removeBackpackFromCart().removeBikeLightFromCart()
                .removeBoltTShirtFromCart().removeFleeceJacketFromCart()
                .removeOnesieFromCart()
                .verifyProductNumber("1");
    }
    @Tag("Cart")
    @Description("Adding All products to cart then remove them than add all ")
    @TmsLink("TC_03")
    @Test(priority = 3)
    public void addAllProductsToCartThenRemoveThemThenAddAll()
    {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton()
                .addBackpack().addBikeLight()
                .addBoltTShirt().addFleeceJacket()
                .addOnesie().addRedShirt()
                .clickShoppingCartBadge()
                .removeBackpackFromCart().removeBikeLightFromCart()
                .removeBoltTShirtFromCart().removeFleeceJacketFromCart()
                .removeOnesieFromCart().removeRedShirtCart()
                .backToProductsPage()
                .addBackpack().addBikeLight()
                .addBoltTShirt().addFleeceJacket()
                .addOnesie().addRedShirt()
                .clickShoppingCartBadge()
                .verifyProductNumber("6");
    }

    @Tag("Cart")
    @Description("Adding Backpack products to cart then find price ")
    @TmsLink("TC_04")
    @Test(priority = 4)
    public void addBackpackProductToCartThenFindPrice()
    {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton()
                .addBackpack()
                .clickShoppingCartBadge()
                .verifyBackpackProductPrice(productsData.getJsonData("Price.backpack"));
    }
    @Tag("Cart")
    @Description("Adding BikeLight products to cart then find price ")
    @TmsLink("TC_05")
    @Test(priority = 5)
    public void addBikeLightProductToCartThenFindPrice()
    {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton()
                .addBikeLight()
                .clickShoppingCartBadge()
                .verifyBikeLightProductPrice(productsData.getJsonData("Price.bikeLight"));
    }
    @Tag("Cart")
    @Description("Adding BoltTShirt products to cart then find price ")
    @TmsLink("TC_06")
    @Test(priority = 6)
    public void addBoltTShirtProductToCartThenFindPrice()
    {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton()
                .addBoltTShirt()
                .clickShoppingCartBadge()
                .verifyBoltTShirtProductPrice(productsData.getJsonData("Price.boltTShirt"));
    }
    @Tag("Cart")
    @Description("Adding FleeceJacket products to cart then find price ")
    @TmsLink("TC_07")
    @Test(priority = 7)
    public void addFleeceJacketProductToCartThenFindPrice()
    {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton()
                .addFleeceJacket()
                .clickShoppingCartBadge()
                .verifyFleeceJacketProductPrice(productsData.getJsonData("Price.fleeceJacket"));
    }
    @Tag("Cart")
    @Description("Adding Onesie products to cart then find price ")
    @TmsLink("TC_08")
    @Test(priority = 8)
    public void addOnesieProductToCartThenFindPrice()
    {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton()
                .addOnesie()
                .clickShoppingCartBadge()
                .verifyOnesieProductPrice(productsData.getJsonData("Price.onesie"));
    }
    @Tag("Cart")
    @Description("Adding RedShirt products to cart then find price ")
    @TmsLink("TC_09")
    @Test(priority = 9)
    public void addRedShirtProductToCartThenFindPrice()
    {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton()
                .addRedShirt()
                .clickShoppingCartBadge()
                .verifyRedShirtProductPrice(productsData.getJsonData("Price.redShirt"));
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
