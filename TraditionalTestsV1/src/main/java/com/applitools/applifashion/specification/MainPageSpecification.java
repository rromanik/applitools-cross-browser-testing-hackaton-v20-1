package com.applitools.applifashion.specification;

import com.applitools.applifashion.pages.MainPage;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Dimension;

import static com.applitools.applifashion.pages.AppliFashionApp.getDriver;

public class MainPageSpecification extends Specification{

    private final MainPage mainPage;

    public MainPageSpecification(MainPage mainPage, SoftAssertions softAssertions, int task) {
        super(softAssertions, task);
        this.mainPage = mainPage;
    }

    @Override
    protected void validate1200x700() {
        expectIsDisplayed(mainPage.searchInputField(), "Search input field");
        expectIsDisplayed(mainPage.topNavigationMenu(), "Top Navigation menu");

        expectIsDisplayed(mainPage.sideBarFiltersPane(), "Side-bar Filters pane");
        expectIsDisplayed(mainPage.productGrid(), "Product grid");

        expectIsHidden(mainPage.openFiltersButton(), "Filters button");
        expectIsDisplayed(mainPage.gridViewButton(), "Grid View button");
        expectIsDisplayed(mainPage.listViewButton(), "List View button");
    }

    @Override
    protected void validate768x700() {
        expectIsDisplayed(mainPage.searchInputField(), "Search input field");
        expectIsHidden(mainPage.topNavigationMenu(), "Top Navigation menu");

        expectIsHidden(mainPage.sideBarFiltersPane(), "Side-bar Filters pane");
        expectIsDisplayed(mainPage.productGrid(),"Product grid");

        expectIsDisplayed(mainPage.openFiltersButton(), "Filters button");
        expectIsHidden(mainPage.gridViewButton(), "Grid View button");
        expectIsHidden(mainPage.listViewButton(), "List View button");
    }

    @Override
    protected void validate500x700() {
        expectIsHidden(mainPage.searchInputField(), "Search input field");
        expectIsHidden(mainPage.topNavigationMenu(), "Top Navigation menu");

        expectIsHidden(mainPage.sideBarFiltersPane(), "Side-bar Filters pane");
        expectIsDisplayed(mainPage.productGrid(),"Product grid");

        expectIsDisplayed(mainPage.openFiltersButton(), "Filters button");
        expectIsHidden(mainPage.gridViewButton(), "Grid View button");
        expectIsHidden(mainPage.listViewButton(), "List View button");
    }

}
