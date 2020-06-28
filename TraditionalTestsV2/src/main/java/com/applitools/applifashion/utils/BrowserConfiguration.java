package com.applitools.applifashion.utils;

import org.openqa.selenium.Dimension;

import java.util.Objects;

public class BrowserConfiguration {

    private final String browserType;

    private final Dimension dimension;

    private final String device;

    public BrowserConfiguration(String browserType, Dimension dimension, String device) {
        this.browserType = browserType;
        this.dimension = dimension;
        this.device = device;
    }

    public String getBrowserType() {
        return this.browserType;
    }

    public Dimension getDimension() {
        return this.dimension;
    }

    public String getDevice() {
        return this.device;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrowserConfiguration that = (BrowserConfiguration) o;
        return Objects.equals(browserType, that.browserType) &&
                Objects.equals(dimension, that.dimension) &&
                Objects.equals(device, that.device);
    }

    @Override
    public int hashCode() {
        return Objects.hash(browserType, dimension, device);
    }

    @Override
    public String toString() {
        return "BrowserConfiguration{" +
                "browserType='" + browserType + '\'' +
                ", dimension=" + dimension +
                ", device='" + device + '\'' +
                '}';
    }
}
