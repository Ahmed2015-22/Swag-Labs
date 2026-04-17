package com.swaglabs;

import com.swaglabs.drivers.GUIDriver;
import com.swaglabs.pages.P1_LoginPage;
import com.swaglabs.pages.P4_CheckoutPage;
import com.swaglabs.utils.dataReader.JsonReader;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


@Epic("Swag Labs")
@Feature("UI User Management")
@Story("Checkout Page")
@Severity(SeverityLevel.CRITICAL)
@Owner("Tal3at")
@Link("https://www.saucedemo.com/")
public class TC4_CheckTest extends BaseTest{


    @Tag("Checkout")
    @Description("Enter Delivery Information")
    @TmsLink("TC_01")
    @Test(priority = 1)
    public void testCheckoutWithValidData() {
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
                .clickContinue();
        new P4_CheckoutPage(driver)
                .verifyOverViewLink(CheckoutData.getJsonData("overviewLink"));
    }
    @Tag("Checkout")
    @Description("Enter Delivery Information without Firstname")
    @TmsLink("TC_02")
    @Test(priority = 2)
    public void testCheckoutWithoutFirstName() {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton()
                .addBackpack().addRedShirt()
                .addBoltTShirt().addFleeceJacket()
                .clickShoppingCartBadge()
                .checkoutPage()

                .enterLastName(CheckoutData.getJsonData("SecondName"))
                .enterZipCode(CheckoutData.getJsonData("ZIPCode"))
                .clickContinue();
        new P4_CheckoutPage(driver)
                .errorMassage(CheckoutData.getJsonData("massage.fName"));
    }

    @Tag("Checkout")
    @Description("Enter Delivery Information without Lastname")
    @TmsLink("TC_03")
    @Test(priority = 3)
    public void testCheckoutWithoutLastName() {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton()
                .addBackpack().addRedShirt()
                .addBoltTShirt().addFleeceJacket()
                .clickShoppingCartBadge()
                .checkoutPage()
                .enterFirstName(CheckoutData.getJsonData("FirstName"))
                .enterZipCode(CheckoutData.getJsonData("ZIPCode"))
                .clickContinue();
        new P4_CheckoutPage(driver)
                .errorMassage(CheckoutData.getJsonData("massage.lName"));
    }

    @Tag("Checkout")
    @Description("Enter Delivery Information without ZipCode")
    @TmsLink("TC_04")
    @Test(priority = 4)
    public void testCheckoutWithoutZipCode() {
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
                .clickContinue();
        new P4_CheckoutPage(driver)
                .errorMassage(CheckoutData.getJsonData("massage.postal"));
    }

    @Description("Preparing Login data")
    @BeforeClass
    protected void preCondition() {
        loginData = new JsonReader("login-data");
        productsData = new JsonReader("products-data");
        CheckoutData = new JsonReader("checkout-data");

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
