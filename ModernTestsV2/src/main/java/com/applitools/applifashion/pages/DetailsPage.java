package com.applitools.applifashion.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DetailsPage {

    public DetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
