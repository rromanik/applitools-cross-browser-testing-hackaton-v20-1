package com.applitools.applifashion.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import static com.applitools.applifashion.pages.AppliFashionApp.getBrowserConfiguration;

public class Reporter {

    private static final String TEST_RESULTS_FILE_NAME = ConfigurationManager.getTestResultsFileName();

    public static void report(int task, String testName, String domId, String testStatus) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(TEST_RESULTS_FILE_NAME, true))) {
            writer.write(format(task, testName, domId, testStatus));
            writer.newLine();
        } catch (Exception e) {
            System.out.println("Error writing to report file");
            e.printStackTrace();
        }
    }

    private static String format(int task, String testName, String domId, String testStatus) {
        BrowserConfiguration browserConfiguration = getBrowserConfiguration();
        return String.format("Task: %1s| Test Name: %-55s| DOM Id: %-20s| Browser: %-14s| Viewport: %-12s| Device: %-6s| Status: %-5s", task, testName,
                domId, browserConfiguration.getBrowserType(), browserConfiguration.getDimension(), browserConfiguration.getDevice(),
                testStatus);
    }

    public static void print() {
        try(BufferedReader reader = new BufferedReader(new FileReader(TEST_RESULTS_FILE_NAME))) {
            reader.lines().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error printing report to console");
            e.printStackTrace();
        }
    }
}
