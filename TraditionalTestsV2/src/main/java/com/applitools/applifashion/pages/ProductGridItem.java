package com.applitools.applifashion.pages;

import com.applitools.applifashion.pages.ui.AbstractGuiElement;
import com.applitools.applifashion.pages.ui.Button;
import com.applitools.applifashion.pages.ui.Image;
import com.applitools.applifashion.pages.ui.Label;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductGridItem extends AbstractGuiElement {

    @FindBy(css = ".img-fluid")
    private WebElement productImage;

    @FindBy(css = "a>h3")
    private WebElement nameLabel;

    @FindBy(css = "[data-original-title='Add to favorites'],[title='Add to favorites']")
    private WebElement addToFavoritesIcon;

    @FindBy(css = "[data-original-title='Add to compare'],[title='Add to compare']")
    private WebElement addToCompareIcon;

    @FindBy(css = "[data-original-title='Add to cart'],[title='Add to cart']")
    private WebElement addToCartIcon;

    public ProductGridItem(WebElement element) {
        super(element);;
    }

    // #### Typified GUI  Elements #### //

    public Image productImage() {
        return new Image(productImage);
    }

    public Label nameLabel() {
        return new Label(nameLabel);
    }

    public Button addToFavoritesIcon() {
        return new Button(addToFavoritesIcon);
    }

    public Button addToCompareIcon() {
        return new Button(addToCompareIcon);
    }

    public Button addToCartIcon() {
        return new Button(addToCartIcon);
    }
}

