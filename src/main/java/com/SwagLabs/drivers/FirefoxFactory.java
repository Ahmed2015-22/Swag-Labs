/*package com.automationexercices.drivers;

import com.automationexercices.utils.dataReader.PropertyReader;
import com.automationexercices.utils.logs.LogsManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class FirefoxFactory extends AbstractDriver {
    private FirefoxOptions getOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.addArguments("--start-maximized");
        Map<String, Object> prefs = new HashMap<>();
        String userDir = System.getProperty("user.dir");
        String downloadPath = userDir + "\\src\\test\\resources\\downloads";
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.default_directory",downloadPath);
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        options.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        FirefoxProfile profile = new FirefoxProfile();
        options.setProfile(profile);
        switch (PropertyReader.getProperty("executionType"))
        {
            case "LocalHeadless" -> options.addArguments("--headless=new");
            case  "Remote" ->
            {
                options.addArguments("--disable-gpu");
                options.addArguments("--disable-extensions");
                options.addArguments("--headless=new");
            }
        }
        return options;
    }

    @Override
    public WebDriver createDriver() {
        if (PropertyReader.getProperty("executionType").equalsIgnoreCase("Local") ||
                PropertyReader.getProperty("executionType").equalsIgnoreCase("LocalHeadless") )
        {
            return new FirefoxDriver(getOptions());
        }
        else if (PropertyReader.getProperty("executionType").equalsIgnoreCase("Remote")) {
            try {
                return new RemoteWebDriver(
                        new URI("http://"+ remoteHost+ ":" +remotePort + "/wd/hub").toURL(), getOptions()
                );
            }
            catch (Exception e) {
                LogsManager.error("Error creating RemoteWebDriver: " + e.getMessage());
                throw new RuntimeException("Failed to create RemoteWebDriver", e);
            }

        }
        else {
            LogsManager.error("Invalid execution type: " + PropertyReader.getProperty("executionType"));
            throw new IllegalArgumentException("Invalid execution type: " + PropertyReader.getProperty("executionType"));
        }
    }
}*/
package com.swaglabs.drivers;

import com.swaglabs.utils.dataReader.PropertyReader;
import com.swaglabs.utils.logs.LogsManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;

public class FirefoxFactory extends AbstractDriver {

    private FirefoxOptions getOptions() {
        FirefoxOptions options = new FirefoxOptions();

        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.addArguments("--start-maximized");


        String userDir = System.getProperty("user.dir");
        String downloadPath = userDir + "\\src\\test\\resources\\downloads";

        // Preferences
        FirefoxProfile profile = new FirefoxProfile();

        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.dir", downloadPath);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
        profile.setPreference("download.prompt_for_download", false);

        // منع الـ popups والإعلانات المزعجة
        profile.setPreference("dom.disable_open_during_load", true);
        profile.setPreference("privacy.popups.showBrowserMessage", false);
        profile.setPreference("dom.popup_maximum", 0);

        // ✅ إضافة الـ Extension (xpi)
        if (fireFoxAddBlock.exists()) {
            profile.addExtension(fireFoxAddBlock);
            LogsManager.info("Extension added successfully");
        } else {
            LogsManager.warn("Extension file not found!");
        }

        options.setProfile(profile);

        // Capabilities
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        options.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

        // Execution Type Handling
        switch (PropertyReader.getProperty("executionType")) {

            case "LocalHeadless" -> options.addArguments("--headless=new");

            case "Remote" -> {
                options.addArguments("--disable-gpu");
                options.addArguments("--headless=new");
                // ❌ شيلنا disable-extensions عشان يشتغل
            }
        }

        return options;
    }

    @Override
    public WebDriver createDriver() {
        WebDriver driver;

        String executionType = PropertyReader.getProperty("executionType");

        if (executionType.equalsIgnoreCase("Local") ||
                executionType.equalsIgnoreCase("LocalHeadless")) {

            driver = new FirefoxDriver(getOptions());

        } else if (executionType.equalsIgnoreCase("Remote")) {
            try {
                driver = new RemoteWebDriver(
                        new URI("http://" + remoteHost + ":" + remotePort + "/wd/hub").toURL(),
                        getOptions()
                );
            } catch (Exception e) {
                LogsManager.error("Error creating RemoteWebDriver: " + e.getMessage());
                throw new RuntimeException("Failed to create RemoteWebDriver", e);
            }
        } else {
            LogsManager.error("Invalid execution type: " + executionType);
            throw new IllegalArgumentException("Invalid execution type: " + executionType);
        }

        if (driver != null) {
            driver.manage().window().maximize();
        }

        return driver;
    }
}
