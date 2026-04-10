package com.swaglabs;

import com.swaglabs.drivers.GUIDriver;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.utils.dataReader.JsonReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckOutTest extends BaseTest {
    JsonReader loginData = new JsonReader("login-data");
    JsonReader checkoutData = new JsonReader("checkout-data");

    @Test
    public void completeCheckOutTC()
    {

        new LoginPage(driver).enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton()
                .addProductOneToCart().addProductTwoToCart()
                .addProductSixToCart().navigateToCartPage()
                .removeProductSixFromCart().clickCheckoutButton()
                .enterFirstName(checkoutData.getJsonData("First-name"))
                .enterLastName(checkoutData.getJsonData("Second-name"))
                .enterPostalCode(checkoutData.getJsonData("ZIP-code"))
                .clickContinueButton().clickFinishButton()
                .verifyHeaderTag("Thank you for your order!");
    }

    @BeforeClass
    protected void preCondition() {
        testData = new JsonReader("login-data");


    }
    @BeforeMethod
    public void setUp() {
        driver = new GUIDriver();
        new LoginPage(driver).navigate();
    }

    @AfterMethod
    public void tearDown() {
        driver.quitDriver();
    }
}
