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
@Story("User Login")
@Severity(SeverityLevel.CRITICAL)
@Owner("Tal3at")
@Link("https://www.saucedemo.com/")
public class TC1_LoginTest extends BaseTest {



    @Tag("Login")
    @Description("Login with valid data")
    @TmsLink("TC_01")
    @Test(priority = 1)
    public void testLoginWithValidData() {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton();
        new P1_LoginPage(driver)
                .verifyCurrentUrl(loginData.getJsonData("landingPageUrl"));
    }

    @Tag("Login")
    @Description("Login with Valid User and Invalid Password")
    @TmsLink("TC_02")
    @Test(priority = 2)
    public void testLoginWithValidUserAndInvalidPassword() {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("invalidPassword"))
                .clickLoginButton();
        new P1_LoginPage(driver)
                .verifyLoginErrorMsg(loginData.getJsonData("messages.error_user_or_pass"));
    }
    @Tag("Login")
    @Description("Login with Invalid User and Valid Password")
    @TmsLink("TC_03")
    @Test(priority = 3)
    public void testLoginWithInvalidUserAndValidPassword() {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("invalidUsername"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton();
        new P1_LoginPage(driver)
                .verifyLoginErrorMsg(loginData.getJsonData("messages.error_user_or_pass"));
    }
    @Tag("Login")
    @Description("Login with Invalid User and Valid Password")
    @TmsLink("TC_04")
    @Test(priority = 4)
    public void testLoginWithInvalidUserAndInvalidPassword() {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("invalidUsername"))
                .enterPassword(loginData.getJsonData("invalidPassword"))
                .clickLoginButton();
        new P1_LoginPage(driver)
                .verifyLoginErrorMsg(loginData.getJsonData("messages.error_user_or_pass"));
    }

    @Tag("Login")
    @Description("Login with Empty User and Empty Password")
    @TmsLink("TC_05")
    @Test(priority = 5)
    public void testLoginWithEmptyUserAndEmptyPassword() {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("emptyUsername"))
                .enterPassword(loginData.getJsonData("emptyPassword"))
                .clickLoginButton();
        new P1_LoginPage(driver)
                .verifyLoginErrorMsg(loginData.getJsonData("messages.error_username_required"));
    }
    @Tag("Login")
    @Description("Login with Empty User and Valid Password")
    @TmsLink("TC_06")
    @Test(priority = 6)
    public void testLoginWithEmptyUserAndPassword() {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("emptyUsername"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton();
        new P1_LoginPage(driver)
                .verifyLoginErrorMsg(loginData.getJsonData("messages.error_username_required"));
    }
    @Tag("Login")
    @Description("Login with Valid User and Empty Password")
    @TmsLink("TC_07")
    @Test(priority = 7)
    public void testLoginWithUserAndEmptyPassword() {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("usernames"))
                .enterPassword(loginData.getJsonData("emptyPassword"))
                .clickLoginButton();
        new P1_LoginPage(driver)
                .verifyLoginErrorMsg(loginData.getJsonData("messages.error_password_required"));
    }

    @Tag("Login")
    @Description("Login with Locked User")
    @TmsLink("TC_08")
    @Test(priority = 8)
    public void testLoginWithLockedUser() {
        new P1_LoginPage(driver)
                .enterUsername(loginData.getJsonData("lockedUser"))
                .enterPassword(loginData.getJsonData("password"))
                .clickLoginButton();
        new P1_LoginPage(driver)
                .verifyLoginErrorMsg(loginData.getJsonData("messages.locked_user"));
    }


    @Description("Preparing Login data")
    @BeforeClass
    protected void preCondition() {
        loginData = new JsonReader("login-data");
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
