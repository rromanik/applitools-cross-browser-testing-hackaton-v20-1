package com.applitools.applifashion.tests;

import com.applitools.applifashion.pages.AppliFashionApp;
import com.applitools.applifashion.pages.MainPage;
import com.applitools.applifashion.utils.EyesManager;
import com.applitools.eyes.TestResultsSummary;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.applitools.applifashion.pages.MainPage.PRODUCT_GRID_ID;

public class AppliFashionVisualTests {

    private MainPage mainPage;

    private static EyesManager eyesManager;

    @BeforeAll
    public static void suiteSetup() {
        eyesManager = new EyesManager();
    }

    @Test
    public void verifyMainPage() {
        // Open the application under test
        mainPage = AppliFashionApp.openOnMainPage();
        // Analyze the Main page
        eyesManager.validateWindowFully("Task 1", "Cross-Device Elements Test");

        mainPage.filterBy("Black");
        // Analyze Filtere Results
        eyesManager.validateRegion("Task 2", "Filter Results", By.id(PRODUCT_GRID_ID));

        // Analyze Filtere Results
        mainPage.productGrid().selectItemByIndex(0);
        eyesManager.validateWindowFully("Task 3", "Product Details test");
    }

    @AfterEach
    public void tearDown() {
        AppliFashionApp.close();
    }

    @AfterAll
    public static void suiteTearDown() {
        TestResultsSummary allTestResults = eyesManager.getAllTestResults(false);
        System.out.println(allTestResults);
    }

}
