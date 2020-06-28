package com.applitools.applifashion.pages.ui;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class AbstractGuiElement {
    private final SearchContext root;

    private WebElementUtils webElementUtils;

    protected AbstractGuiElement(WebElement root) {
        this.root = root;
        PageFactory.initElements(new DefaultElementLocatorFactory(root), this);
    }

    protected WebElementUtils webElementUtils() {
        if (webElementUtils == null)
            webElementUtils = WebElementUtils.getInstance();
        return webElementUtils;
    }

    public boolean isDisplayed() {
        return webElementUtils().isElementDisplayed(getWrappedElement());
    }

    public void click() {
        webElementUtils().clickOn(getWrappedElement());
    }

    public String getAttribute(String attributeName) {
        return getWrappedElement().getAttribute(attributeName);
    }

    public WebElement getWrappedElement() {
        return (WebElement) root;
    }

    public void scrollIntoView() {
        webElementUtils().scrollIntoView(getWrappedElement());
    }

}
