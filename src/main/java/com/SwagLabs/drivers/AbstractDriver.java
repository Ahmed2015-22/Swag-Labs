package com.swaglabs.drivers;

import com.swaglabs.utils.dataReader.PropertyReader;
import org.openqa.selenium.WebDriver;

import java.io.File;

public abstract class AbstractDriver {
    protected final String remoteHost = PropertyReader.getProperty("remoteHost");
    protected final String remotePort = PropertyReader.getProperty("remotePort");
    protected File addBlock = new File("src/main/resources/extensions/uBlock.crx");
    protected File addBlock1 = new File("src/main/resources/extensions/BlockAdd1.crx");
    protected File addBlock2 = new File("src/main/resources/extensions/BlockAdd2.crx");
    protected File fireFoxAddBlock = new File("src/main/resources/extensions/ublockorigin.xpi");

    protected String downloadsPath = System.getProperty("user.dir") + "\\src\\test\\resources";
    public abstract WebDriver createDriver();
}
