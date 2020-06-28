package com.applitools.applifashion.pages;

import com.applitools.applifashion.pages.ui.Image;
import com.applitools.applifashion.pages.ui.Label;
import com.applitools.applifashion.specification.DetailsPageSpecification;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.applitools.applifashion.pages.AppliFashionApp.getDriver;

public class DetailsPage {

    @FindBy(id = "shoe_img")
    private WebElement shoeImage;

    @FindBy(id = "new_price")
    private WebElement newPriceLabel;

    public DetailsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public Image shoeImage() {
        return new Image(shoeImage);
    }

    public Label newPriceLabel() {
        return new Label(newPriceLabel);
    }

    public void validate(SoftAssertions softAssertions, int task) {
        new DetailsPageSpecification(this, softAssertions, task).validate();
    }
}
