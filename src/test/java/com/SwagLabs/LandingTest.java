package com.swaglabs;

import com.swaglabs.drivers.GUIDriver;
import com.swaglabs.pages.LandingPage;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.utils.TimeManager;
import com.swaglabs.utils.dataReader.JsonReader;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


@Epic("Swag Labs")
@Feature("UI User Management")
@Story("Products Landing Page")
@Severity(SeverityLevel.CRITICAL)
@Owner("Tal3at")

public class LandingTest extends BaseTest {
    String timestamp = TimeManager.getSimpleTimestamp();

    @Test
    public void addProductsToCartTC() {
        // Test implementation goes here
        new LoginPage(driver).navigate()
                .enterUsername(testData.getJsonData("usernames"))
                .enterPassword(testData.getJsonData("password"))
                .clickLoginButton()
                .addProductOneToCart().addProductTwoToCart()
                .addProductThreeToCart().addProductFourToCart()
                .addProductFiveToCart().addProductSixToCart();

        new LandingPage(driver).verifyProductNumber("6");
        // Add verification steps as needed


    }

    @BeforeClass
    protected void preCondition() {
        testData = new JsonReader("login-data");
    }
    @BeforeMethod
    public void setUp() {
        driver = new GUIDriver();
        driver.browser().closeExtensionTab();
    }

    @AfterMethod
    public void tearDown() {
        driver.quitDriver();
    }
}
