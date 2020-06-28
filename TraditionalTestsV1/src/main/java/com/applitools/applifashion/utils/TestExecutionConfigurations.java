package com.applitools.applifashion.utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.BrowserType;

import java.util.ArrayList;
import java.util.List;

public class TestExecutionConfigurations {

    private static final String LAPTOP = "Laptop";

    private static final String TABLET = "Tablet";

    private static final String MOBIlE = "Mobile";

    public static final Dimension DIMENSION_1200x700 = new Dimension(1200, 700);

    public static final Dimension DIMENSION_786x700 = new Dimension(786, 700);

    public static final Dimension DIMENSION_500x700 = new Dimension(500, 700);

    public static final BrowserConfiguration DEFAULT_BROWSER_CONFIGURATION = new BrowserConfiguration(BrowserType.CHROME, DIMENSION_1200x700, LAPTOP);

    public static List<BrowserConfiguration> getBrowserConfigurations() {
        List<BrowserConfiguration> configurations = new ArrayList<>();
        configurations.add(new BrowserConfiguration(BrowserType.CHROME, DIMENSION_1200x700, LAPTOP));
        configurations.add(new BrowserConfiguration(BrowserType.FIREFOX, DIMENSION_1200x700, LAPTOP));
        configurations.add(new BrowserConfiguration(BrowserType.EDGE, DIMENSION_1200x700, LAPTOP));
        configurations.add(new BrowserConfiguration(BrowserType.CHROME, DIMENSION_786x700, TABLET));
        configurations.add(new BrowserConfiguration(BrowserType.FIREFOX, DIMENSION_786x700, TABLET));
        configurations.add(new BrowserConfiguration(BrowserType.EDGE, DIMENSION_786x700, TABLET));

        configurations.add(new BrowserConfiguration(BrowserType.CHROME, DIMENSION_500x700, MOBIlE));
        return configurations;
    }
}
