package com.applitools.applifashion.pages;

import com.applitools.applifashion.pages.ui.Button;
import com.applitools.applifashion.pages.ui.Input;
import com.applitools.applifashion.specification.MainPageSpecification;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.applitools.applifashion.pages.AppliFashionApp.getDriver;

public class MainPage {

    @FindBy(css = ".custom-search-input")
    private WebElement searchInput;

    @FindBy(css = ".main-menu")
    private WebElement topNavigationMenu;

    public static final String PRODUCT_GRID_ID = "product_grid";

    @FindBy(id = PRODUCT_GRID_ID)
    private WebElement productGrid;

    @FindBy(id = "filter_col")
    private WebElement sideBarFilter;

    @FindBy(css = ".clearfix .open_filters")
    private WebElement openFiltersButton;

    @FindBy(css = ".ti-view-grid")
    private WebElement gridViewButton;

    @FindBy(css =".ti-view-list")
    private WebElement listViewButton;

    @FindBy(css = "footer")
    private WebElement footer;

    public MainPage() {
        PageFactory.initElements(getDriver(), this);
    }

    // #### Typified GUI  Elements #### //
    public TopNavigationMenu topNavigationMenu() {
        return new TopNavigationMenu(topNavigationMenu);
    }

    public Input searchInputField() {
        return new Input(searchInput);
    }

    public Button openFiltersButton() {
        return new Button(openFiltersButton);
    }

    public Button gridViewButton() {
        return new Button(gridViewButton);
    }

    public Button listViewButton() {
        return new Button(listViewButton);
    }

    public ProductGrid productGrid() {
        return new ProductGrid(this.productGrid);
    }

    public SideBarFiltersPane sideBarFiltersPane() {
        return new SideBarFiltersPane(sideBarFilter);
    }

    public Footer footer() {
        return new Footer(footer);
    }

    // #### Generic User Scenarios #### //

    public MainPage filterBy(String filterValue) {
        openFilters();
        sideBarFiltersPane().select(filterValue).filter();
        return this;
    }

    public void openFilters() {
        if (!sideBarFiltersPane().isDisplayed())
            openFiltersButton().click();
        new WebDriverWait(getDriver(), 3).until(d -> sideBarFilter.isDisplayed());
    }

    public DetailsPage selectItemByIndex(int index) {
        productGrid().selectItemByIndex(index);
        return new DetailsPage();
    }

    public void validate(SoftAssertions softAssertions, int task) {
        new MainPageSpecification(this, softAssertions, task).validate();
    }
}
