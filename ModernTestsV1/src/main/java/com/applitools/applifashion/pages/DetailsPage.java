package com.applitools.applifashion.pages;

import org.openqa.selenium.support.PageFactory;

import static com.applitools.applifashion.pages.AppliFashionApp.getDriver;

public class DetailsPage {

    public DetailsPage() {
        PageFactory.initElements(getDriver(), this);
    }
}
