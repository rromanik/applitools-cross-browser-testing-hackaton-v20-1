package com.applitools.applifashion.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.applitools.applifashion.pages.AppliFashionApp.getDriver;

public class MainPage {

    public static final String PRODUCT_GRID_ID = "product_grid";

    @FindBy(id = PRODUCT_GRID_ID)
    private WebElement productGrid;

    @FindBy(id = "filter_col")
    private WebElement sideBarFilter;

    @FindBy(css = ".clearfix .open_filters")
    private WebElement openFiltersButton;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public MainPage filterBy(String filterValue) {
        openFilters();
        new SideBarFiltersPane(sideBarFilter).select(filterValue).filter();
        return this;
    }

    public void openFilters() {
        if(!sideBarFilter.isDisplayed())
            openFiltersButton.click();
        new WebDriverWait(getDriver(), 3).until(d -> sideBarFilter.isDisplayed());
    }

    public ProductGrid productGrid() {
        return new ProductGrid(this.productGrid);
    }

}
