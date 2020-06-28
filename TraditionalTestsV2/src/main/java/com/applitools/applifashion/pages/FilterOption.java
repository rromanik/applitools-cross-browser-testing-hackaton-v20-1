package com.applitools.applifashion.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class FilterOption {
    private static final String SELECTED_COLOR = "rgba(0, 77, 218, 1);";

    @FindBy(css = ".checkmark")
    private WebElement checkmark;

    public FilterOption(WebElement root) {
        PageFactory.initElements(new DefaultElementLocatorFactory(root), this);
    }

    private boolean isSelected() {
        String backgroundColor = checkmark.getCssValue("background-color");
        return SELECTED_COLOR.equalsIgnoreCase(backgroundColor);
    }

    public void makeSelected() {
        if(!isSelected())
            checkmark.click();
    }

}
