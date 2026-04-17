package com.swaglabs;

import com.swaglabs.drivers.GUIDriver;
import com.swaglabs.pages.P1_LoginPage;
import com.swaglabs.pages.P5_OverviewPage;
import com.swaglabs.utils.dataReader.JsonReader;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Swag Labs")
@Feature("UI User Management")
@Story("Overview Page")
@Severity(SeverityLevel.CRITICAL)
@Owner("Tal3at")

public class TC5_OverviewTest extends BaseTest {

    @Tag("Overview")
    @Description("Verify Finish Order")
    @TmsLink("TC_01")
    @Test(priority = 1)
    public void verifyFinishOrder()
    {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton()
                .addBackpack().addRedShirt()
                .addBoltTShirt().addFleeceJacket()
                .clickShoppingCartBadge()
                .checkoutPage()
                .enterFirstName(CheckoutData.getJsonData("FirstName"))
                .enterLastName(CheckoutData.getJsonData("SecondName"))
                .enterZipCode(CheckoutData.getJsonData("ZIPCode"))
                .clickContinue()
                .FinishOrder();
        new P5_OverviewPage(driver).verifyCompletePageURL(OverviewData.getJsonData("completePageURL"));
    }

    @Tag("Overview")
    @Description("Verify Payment Info")
    @TmsLink("TC_02")
    @Test(priority = 2)
    public void verifyPaymentInformation()
    {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton()
                .addBackpack().addRedShirt()
                .addBoltTShirt().addFleeceJacket()
                .clickShoppingCartBadge()
                .checkoutPage()
                .enterFirstName(CheckoutData.getJsonData("FirstName"))
                .enterLastName(CheckoutData.getJsonData("SecondName"))
                .enterZipCode(CheckoutData.getJsonData("ZIPCode"))
                .clickContinue()
                .verifyPaymentInformation(OverviewData.getJsonData("PaymentInfo"));
    }
    @Tag("Overview")
    @Description("Verify Shipping Info")
    @TmsLink("TC_03")
    @Test(priority = 3)
    public void verifyShippingInformation()
    {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton()
                .addBackpack().addRedShirt()
                .addBoltTShirt().addFleeceJacket()
                .clickShoppingCartBadge()
                .checkoutPage()
                .enterFirstName(CheckoutData.getJsonData("FirstName"))
                .enterLastName(CheckoutData.getJsonData("SecondName"))
                .enterZipCode(CheckoutData.getJsonData("ZIPCode"))
                .clickContinue()
                .verifyShippingInformation(OverviewData.getJsonData("ShippingInfo"));
    }
    @Tag("Overview")
    @Description("Adding Backpack products to cart then find price at Overview Page ")
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
                .checkoutPage()
                .enterFirstName(CheckoutData.getJsonData("FirstName"))
                .enterLastName(CheckoutData.getJsonData("SecondName"))
                .enterZipCode(CheckoutData.getJsonData("ZIPCode"))
                .clickContinue()
                .verifyBackpackProductPrice(productsData.getJsonData("Price.backpack"));
    }
    @Tag("Overview")
    @Description("Adding BikeLight products to cart then find price at Overview Page ")
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
                .checkoutPage()
                .enterFirstName(CheckoutData.getJsonData("FirstName"))
                .enterLastName(CheckoutData.getJsonData("SecondName"))
                .enterZipCode(CheckoutData.getJsonData("ZIPCode"))
                .clickContinue()
                .verifyBikeLightProductPrice(productsData.getJsonData("Price.bikeLight"));
    }
    @Tag("Overview")
    @Description("Adding BoltTShirt products to cart then find price at Overview Page ")
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
                .checkoutPage()
                .enterFirstName(CheckoutData.getJsonData("FirstName"))
                .enterLastName(CheckoutData.getJsonData("SecondName"))
                .enterZipCode(CheckoutData.getJsonData("ZIPCode"))
                .clickContinue()
                .verifyBoltTShirtProductPrice(productsData.getJsonData("Price.boltTShirt"));
    }
    @Tag("Overview")
    @Description("Adding FleeceJacket products to cart then find price at Overview Page ")
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
                .checkoutPage()
                .enterFirstName(CheckoutData.getJsonData("FirstName"))
                .enterLastName(CheckoutData.getJsonData("SecondName"))
                .enterZipCode(CheckoutData.getJsonData("ZIPCode"))
                .clickContinue()
                .verifyFleeceJacketProductPrice(productsData.getJsonData("Price.fleeceJacket"));
    }
    @Tag("Overview")
    @Description("Adding Onesie products to cart then find price at Overview Page ")
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
                .checkoutPage()
                .enterFirstName(CheckoutData.getJsonData("FirstName"))
                .enterLastName(CheckoutData.getJsonData("SecondName"))
                .enterZipCode(CheckoutData.getJsonData("ZIPCode"))
                .clickContinue()
                .verifyOnesieProductPrice(productsData.getJsonData("Price.onesie"));
    }
    @Tag("Overview")
    @Description("Adding RedShirt products to cart then find price at Overview Page ")
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
                .checkoutPage()
                .enterFirstName(CheckoutData.getJsonData("FirstName"))
                .enterLastName(CheckoutData.getJsonData("SecondName"))
                .enterZipCode(CheckoutData.getJsonData("ZIPCode"))
                .clickContinue()
                .verifyRedShirtProductPrice(productsData.getJsonData("Price.redShirt"));
    }

    @BeforeClass
    protected void preCondition() {

        loginData = new JsonReader("login-data");
        productsData = new JsonReader("product-data");
        CheckoutData = new JsonReader("checkout-data");
        OverviewData = new JsonReader("overview-data");
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
