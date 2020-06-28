package com.applitools.applifashion.utils;

import org.openqa.selenium.WebDriver;

public class Browser {
    private WebDriver driver;

    private BrowserConfiguration browserConfiguration = TestExecutionConfigurations.DEFAULT_BROWSER_CONFIGURATION;

    public WebDriver getDriver() {
        if (this.driver != null)
            return this.driver;
        this.driver = startNewInstance();
        return this.driver;
    }

    public void quit() {
        try {
            if (this.driver != null)
                this.driver.quit();
        } finally {
            this.driver = null;
        }
    }

    public void setBrowserConfiguration(BrowserConfiguration browserConfiguration) {
        this.browserConfiguration = browserConfiguration;
    }

    public BrowserConfiguration getBrowserConfiguration() {
        return this.browserConfiguration;
    }

    private WebDriver startNewInstance() {
        return new WebDriverFactory().startNewInstance(browserConfiguration.getBrowserType(), browserConfiguration.getDimension());
    }
}
