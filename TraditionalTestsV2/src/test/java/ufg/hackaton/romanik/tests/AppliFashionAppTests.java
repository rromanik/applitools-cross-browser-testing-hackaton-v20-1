package ufg.hackaton.romanik.tests;

import com.applitools.applifashion.pages.AppliFashionApp;
import com.applitools.applifashion.pages.DetailsPage;
import com.applitools.applifashion.pages.MainPage;
import com.applitools.applifashion.utils.BrowserConfiguration;
import com.applitools.applifashion.utils.Reporter;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AppliFashionAppTests {

    private MainPage mainPage;
    private DetailsPage detailsPage;

    @ParameterizedTest @Order(1)
    @MethodSource("com.applitools.applifashion.utils.TestExecutionConfigurations#getBrowserConfigurations")
    public void verifyMainPage(BrowserConfiguration browserConfiguration) {
        AppliFashionApp.setBrowserConfiguration(browserConfiguration);
        mainPage = AppliFashionApp.openOnMainPage();
        SoftAssertions softAssertions = new SoftAssertions();
        mainPage.validate(softAssertions, 1);
        mainPage.productGrid().validate(softAssertions, 1);
        mainPage.footer().validate(softAssertions, 1);
        softAssertions.assertAll();
    }

    @ParameterizedTest @Order(2)
    @MethodSource("com.applitools.applifashion.utils.TestExecutionConfigurations#getBrowserConfigurations")
    public void verifyFilterResults(BrowserConfiguration browserConfiguration) {
        AppliFashionApp.setBrowserConfiguration(browserConfiguration);
        mainPage = AppliFashionApp.openOnMainPage().filterBy("Black");

        // Analyze Filter Results
        int actualNumberOfFoundItems = mainPage.productGrid().getItems().size();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(2).withFailMessage("Filter Results: Incorrect number of found items matching filter criteria.")
                .isEqualTo(actualNumberOfFoundItems);
        mainPage.productGrid().validate(softAssertions, 2);
        softAssertions.assertAll();
    }

    @ParameterizedTest @Order(3)
    @MethodSource("com.applitools.applifashion.utils.TestExecutionConfigurations#getBrowserConfigurations")
    public void verifyProductDetailsPage(BrowserConfiguration browserConfiguration) {
        AppliFashionApp.setBrowserConfiguration(browserConfiguration);
        mainPage = AppliFashionApp.openOnMainPage().filterBy("Black");
        detailsPage = mainPage.selectItemByIndex(0);

        SoftAssertions softAssertions = new SoftAssertions();
        detailsPage.validate(softAssertions, 3);
        softAssertions.assertAll();
    }

    @AfterEach
    public void tearDown() {
        AppliFashionApp.close();
    }

    @AfterAll
    public static void printReport() {
        Reporter.print();
    }

}
