package com.applitools.applifashion.specification;

import com.applitools.applifashion.pages.ui.AbstractGuiElement;
import com.applitools.applifashion.utils.Reporter;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriverException;

import static com.applitools.applifashion.pages.AppliFashionApp.getBrowserConfiguration;
import static com.applitools.applifashion.utils.TestExecutionConfigurations.*;

public abstract class Specification {

    protected SoftAssertions softAssertions;

    protected int task;

    protected Specification(SoftAssertions softAssertions, int task) {
        this.softAssertions = softAssertions;
        this.task = task;
    }

    public void validate() {
        validate(getBrowserConfiguration().getDimension());
    }

    private void validate(Dimension dimension) {
        if (dimension.equals(DIMENSION_1200x700)) {
            validate1200x700();
        } else if (dimension.equals(DIMENSION_786x700)) {
            validate768x700();
        } else if (dimension.equals(DIMENSION_500x700)) {
            validate500x700();
        } else
            throw new IllegalArgumentException("Requirements not defined for this browser dimension: " + dimension);
    }

    protected abstract void validate1200x700();

    protected abstract void validate768x700();

    protected abstract void validate500x700();

    protected void expectIsDisplayed(AbstractGuiElement element, String elementName) {
        String testName = String.format("%s is displayed", elementName);
        String domId = getIdOrEmpty(element);
        boolean visible = element.isDisplayed();
        String status = visible ? "PASS" : "FAIL";
        Reporter.report(task, testName, domId, status);
        String failMessage = String.format("%s should be displayed", elementName);
        softAssertions.assertThat(visible).withFailMessage(failMessage).isTrue();
    }

    protected void expectIsHidden(AbstractGuiElement element, String elementName) {
        String testName = String.format("%s is NOT displayed", elementName);
        String domId = getIdOrEmpty(element);
        boolean visible = element.isDisplayed();
        String status = visible ? "FAIL" : "PASS";
        Reporter.report(task, testName, domId, status);
        String failMessage = String.format("%s should NOT be displayed", elementName);
        softAssertions.assertThat(visible).withFailMessage(failMessage).isFalse();
    }

    private String getIdOrEmpty(AbstractGuiElement element) {
        try {
            return element.getAttribute("id");
        } catch (WebDriverException e) {
            return "";
        }
    }
}
