package com.applitools.applifashion.pages.ui;

import org.openqa.selenium.*;

public class WebElementUtils {

    private WebElementUtils() {
    }

    public static WebElementUtils getInstance() {
        return new WebElementUtils();
    }

    /**
     * Returns true if and only if element is present in DOM and is displayed.
     *
     * @param element
     * @return true if {@code element} is visible
     */
    public boolean isElementDisplayed(WebElement element) {
        try {
            return isElementDisplayed0(element);
        } catch (StaleElementReferenceException e) {
            return isElementDisplayed0(element);
        }
    }

    private boolean isElementDisplayed0(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Performs click on element.
     *
     * @param element
     */
    public void clickOn(WebElement element) {
        element.click();
    }

    public void scrollIntoView(WebElement e) {
        getJavascriptExecutor(e).executeScript("arguments[0].scrollIntoView(true)", e);
    }

    private JavascriptExecutor getJavascriptExecutor(WebElement element) {
        return (JavascriptExecutor) unpackWebDriverFromSearchContext(element);
    }

    public static WebDriver unpackWebDriverFromSearchContext(SearchContext searchContext) {
        if (searchContext instanceof WebDriver) {
            return (WebDriver) searchContext;
        }

        if (searchContext instanceof WrapsDriver) {
            return unpackWebDriverFromSearchContext(
                    ((WrapsDriver) searchContext).getWrappedDriver());
        }

        // Search context it is not only Webdriver. Webelement is search context too.
        // RemoteWebElement and MobileElement implement WrapsDriver
        if (searchContext instanceof WrapsElement) {
            return unpackWebDriverFromSearchContext(
                    ((WrapsElement) searchContext).getWrappedElement());
        }

        return null;
    }


}
