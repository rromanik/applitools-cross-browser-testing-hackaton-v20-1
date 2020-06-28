package com.applitools.applifashion.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import java.util.List;

public class ProductGrid {

    private final WebElement root;

    @FindBy(css = ".grid_item")
    private List<WebElement> gritItems;

    public ProductGrid(WebElement root) {
        this.root = root;
        PageFactory.initElements(new DefaultElementLocatorFactory(root), this);
    }

    public void selectItemByIndex(int index) {
        gritItems.get(index).click();
    }

    public WebElement getRootElement() {
        return this.root;
    }
}
