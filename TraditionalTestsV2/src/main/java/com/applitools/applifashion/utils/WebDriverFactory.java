package com.applitools.applifashion.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

public class WebDriverFactory {

    static {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().driverVersion("0.24.0").setup();
        WebDriverManager.edgedriver().setup();
    }

    WebDriver startNewInstance(String browserType, Dimension dimension) {
        switch (browserType) {
            case BrowserType.CHROME:
                return startNewChromeInstance(dimension);
            case BrowserType.FIREFOX:
                return startNewFirefoxInstance(dimension);
            case BrowserType.EDGE:
                return startNewEdgeInstance(dimension);
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserType);
        }
    }

    private WebDriver startNewChromeInstance(Dimension dimension) {
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().setSize(dimension);
        return webDriver;
    }

    private WebDriver startNewFirefoxInstance(Dimension dimension) {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.manage().window().setSize(dimension);
        return webDriver;
    }

    private WebDriver startNewEdgeInstance(Dimension dimension) {
        WebDriver webDriver = new EdgeDriver();
        webDriver.manage().window().setSize(dimension);
        return webDriver;
    }
}
