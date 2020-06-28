package com.applitools.applifashion.pages;

import com.applitools.applifashion.pages.ui.AbstractGuiElement;
import com.applitools.applifashion.specification.ProductGridSpecification;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ProductGrid extends AbstractGuiElement {

    @FindBy(css = ".grid_item")
    private List<WebElement> gritItems;

    public ProductGrid(WebElement root) {
        super(root);
    }

    public void selectItemByIndex(int index) {
        gritItems.get(index).click();
    }

    public List<ProductGridItem> getItems() {
        return gritItems.stream().map(ProductGridItem::new).collect(Collectors.toList());
    }

    public void validate(SoftAssertions softAssertions, int task) {
        new ProductGridSpecification(this, softAssertions, task).validate();
    }
}
