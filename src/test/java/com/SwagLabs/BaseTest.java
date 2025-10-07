package com.SwagLabs;

import com.SwagLabs.drivers.GUIDriver;
import com.SwagLabs.drivers.WebDriverProvider;
import com.SwagLabs.utils.dataReader.JsonReader;
import org.openqa.selenium.WebDriver;

public class BaseTest implements WebDriverProvider {

    protected GUIDriver driver;
    protected JsonReader testData;

    @Override
    public WebDriver getWebDriver() {
        return driver.get();
    }

}
