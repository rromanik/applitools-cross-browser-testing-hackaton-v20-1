package com.applitools.applifashion.pages;

import com.applitools.applifashion.pages.ui.AbstractGuiElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import java.util.List;
import java.util.Optional;

public class SideBarFiltersPane extends AbstractGuiElement {

    @FindBy(css = ".container_check")
    private List<WebElement> filterCheckmarks;

    @FindBy(id = "filterBtn")
    private WebElement filterButton;

    public SideBarFiltersPane(WebElement root) {
        super(root);
    }

    public SideBarFiltersPane select(String filter) {
        Optional<WebElement> foundFilter = findFilter(filter);
        if(!foundFilter.isPresent())
            throw new IllegalArgumentException("There is not such filter option: <" + filter + ">");
        new FilterOption(foundFilter.get()).makeSelected();
        return this;
    }

    public void filter() {
        filterButton.click();
    }

    private Optional<WebElement> findFilter(String filter) {
        return filterCheckmarks.stream().filter(f -> f.getText().startsWith(filter)).findFirst();
    }

}
