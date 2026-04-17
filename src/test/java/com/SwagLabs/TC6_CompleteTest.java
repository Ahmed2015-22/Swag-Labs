package com.swaglabs;

import com.swaglabs.drivers.GUIDriver;
import com.swaglabs.pages.P1_LoginPage;
import com.swaglabs.pages.P6_CompletePage;
import com.swaglabs.utils.dataReader.JsonReader;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


@Epic("Swag Labs")
@Feature("UI User Management")
@Story("Complete Order")
@Severity(SeverityLevel.CRITICAL)
@Owner("Tal3at")
public class TC6_CompleteTest extends BaseTest{

    @Tag("ETE")
    @Description("End to End Test for complete order")
    @TmsLink("TC_01")
    @Test(priority = 1)
    public void endToEndTestForCompleteOrder()
    {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton()
                .addBackpack().addRedShirt()
                .addBoltTShirt().addFleeceJacket()
                .addOnesie().addBikeLight()
                .clickShoppingCartBadge()
                .checkoutPage()
                .enterFirstName(CheckoutData.getJsonData("FirstName"))
                .enterLastName(CheckoutData.getJsonData("SecondName"))
                .enterZipCode(CheckoutData.getJsonData("ZIPCode"))
                .clickContinue()
                .FinishOrder()
                .verifySuccessMessage(OverviewData.getJsonData("successMessage"));
    }

    @Tag("ETE")
    @Description("End to End Test for complete order and Back to Products Page")
    @TmsLink("TC_02")
    @Test(priority = 2)
    public void completeOrderAndBackToProductsPage()
    {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton()
                .addBackpack().addRedShirt()
                .addBoltTShirt().addFleeceJacket()
                .addOnesie().addBikeLight()
                .clickShoppingCartBadge()
                .checkoutPage()
                .enterFirstName(CheckoutData.getJsonData("FirstName"))
                .enterLastName(CheckoutData.getJsonData("SecondName"))
                .enterZipCode(CheckoutData.getJsonData("ZIPCode"))
                .clickContinue()
                .FinishOrder()
                .clickOnBackToHome();
        new P6_CompletePage(driver)
                .verifyBackToHome(loginData.getJsonData("landingPageUrl"));
    }
    @Tag("ETE")
    @Description("Complete Order and Reorder")
    @TmsLink("TC_03")
    @Test(priority = 3)
    public void completeOrderAndReorder()
    {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton()
                .addBackpack().addRedShirt()
                .addBoltTShirt().addFleeceJacket()
                .addOnesie().addBikeLight()
                .clickShoppingCartBadge()
                .checkoutPage()
                .enterFirstName(CheckoutData.getJsonData("FirstName"))
                .enterLastName(CheckoutData.getJsonData("SecondName"))
                .enterZipCode(CheckoutData.getJsonData("ZIPCode"))
                .clickContinue()
                .FinishOrder()
                .clickOnBackToHome()
                .addBackpack().addRedShirt()
                .addBoltTShirt().addFleeceJacket()
                .addOnesie().addBikeLight()
                .clickShoppingCartBadge()
                .checkoutPage()
                .enterFirstName(CheckoutData.getJsonData("FirstName"))
                .enterLastName(CheckoutData.getJsonData("SecondName"))
                .enterZipCode(CheckoutData.getJsonData("ZIPCode"))
                .clickContinue()
                .FinishOrder()
                .verifySuccessMessage(OverviewData.getJsonData("successMessage"));
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
