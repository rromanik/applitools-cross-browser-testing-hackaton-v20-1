package com.applitools.applifashion.utils;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import org.openqa.selenium.By;

import static com.applitools.applifashion.pages.AppliFashionApp.getDriver;

public class EyesManager {

    private static final BatchInfo BATCH_INFO = new BatchInfo("UFG Hackathon");

    private RectangleSize rectangleSize = new RectangleSize(800, 600);

    private VisualGridRunner runner;
    private Eyes eyes;

    public EyesManager() {
        this.runner = new VisualGridRunner(10);
        this.eyes = new Eyes(runner);
        setUp();
    }

    public RectangleSize getRectangleSize() {
        return this.rectangleSize;
    }

    public void setRectangleSize(RectangleSize rectangleSize) {
        this.rectangleSize = rectangleSize;
    }

    public void validateWindowFully(String testName, String stepName) {
        eyes.open(getDriver(), ConfigurationManager.getAppName(), testName, this.rectangleSize);
        eyes.check(Target.window().fully().withName(stepName));
        eyes.closeAsync();
    }

    public void validateRegion(String testName, String stepName, By by) {
        eyes.open(getDriver(), ConfigurationManager.getAppName(), testName, this.rectangleSize);
        eyes.check(stepName, Target.region(by));
        eyes.closeAsync();
    }

    public void abortIfNotClosed() {
        eyes.abortIfNotClosed();
    }


    private void setUp() {
        Configuration config = new Configuration();
        config.setApiKey(ConfigurationManager.getApplitoolsApiKey());
        config.setBatch(BATCH_INFO);

        // Add browsers with different viewports
        config.addBrowser(1200, 700, BrowserType.CHROME);
        config.addBrowser(1200, 700, BrowserType.FIREFOX);
        config.addBrowser(1200, 700, BrowserType.EDGE_CHROMIUM);
        config.addBrowser(768, 700, BrowserType.CHROME);
        config.addBrowser(768, 700, BrowserType.FIREFOX);
        config.addBrowser(768, 700, BrowserType.EDGE_CHROMIUM);
        config.addDeviceEmulation(DeviceName.iPhone_X, ScreenOrientation.PORTRAIT);

        eyes.setConfiguration(config);
    }

    public TestResultsSummary getAllTestResults(boolean shouldThrowException) {
        return runner.getAllTestResults(shouldThrowException);
    }
}
