package com.applitools.applifashion.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationManager {

    private static Properties configProperties;

    public static String getAppUrl() {
        return getProperty("app.url");
    }

    public static String getAppName() {
        return getProperty("app.name");
    }

    public static String getTestResultsFileName() {
        return getProperty("test.results.file");
    }

    public static String getProperty(String key) {
        return getConfigProperties().getProperty(key);
    }

    private static Properties getConfigProperties() {
        if (configProperties == null)
            initProperties();
        return configProperties;
    }

    private static void initProperties() {
        String configFileName = "config.properties";
        configProperties = new Properties();

        try (InputStream inputStream = ConfigurationManager.class.getClassLoader().getResourceAsStream(configFileName);){
            if (inputStream == null) {
                throw new RuntimeException("Configuration Manager couldn't read properties.");
            }
            configProperties.load(inputStream);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
