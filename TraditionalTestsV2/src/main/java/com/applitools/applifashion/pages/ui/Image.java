package com.applitools.applifashion.pages.ui;

import org.openqa.selenium.WebElement;

public class Image extends AbstractGuiElement {

    public Image(WebElement root) {
        super(root);
    }

    public String getSource() {
        return getAttribute("src");
    }

    public String getAlt() {
        return getAttribute("alt");
    }
}
