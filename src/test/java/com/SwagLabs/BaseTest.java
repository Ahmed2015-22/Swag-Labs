package com.swaglabs;

import com.swaglabs.drivers.GUIDriver;
import com.swaglabs.drivers.WebDriverProvider;
import com.swaglabs.utils.dataReader.JsonReader;
import org.openqa.selenium.WebDriver;

public class BaseTest implements WebDriverProvider {

    protected GUIDriver driver;
    protected JsonReader testData;

    @Override
    public WebDriver getWebDriver() {
        return driver.get();
    }

}
