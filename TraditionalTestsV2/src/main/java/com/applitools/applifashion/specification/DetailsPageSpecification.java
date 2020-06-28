package com.applitools.applifashion.specification;

import com.applitools.applifashion.pages.DetailsPage;
import org.assertj.core.api.SoftAssertions;

public class DetailsPageSpecification extends Specification {

    private final DetailsPage detailsPage;

    public DetailsPageSpecification(DetailsPage detailsPage, SoftAssertions softAssertions, int task) {
        super(softAssertions, task);
        this.detailsPage = detailsPage;
    }

    @Override
    protected void validate1200x700() {
        expectIsDisplayed(detailsPage.shoeImage(), "Shoe image");
        expectIsDisplayed(detailsPage.newPriceLabel(), "'New price' label");
    }

    @Override
    protected void validate768x700() {
        expectIsDisplayed(detailsPage.shoeImage(), "Shoe image");
        expectIsDisplayed(detailsPage.newPriceLabel(), "'New price' label");
    }

    @Override
    protected void validate500x700() {
        expectIsDisplayed(detailsPage.shoeImage(), "Shoe image");
        expectIsDisplayed(detailsPage.newPriceLabel(), "'New price' label");
    }

}
