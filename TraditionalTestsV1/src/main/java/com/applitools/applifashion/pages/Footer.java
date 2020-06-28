package com.applitools.applifashion.pages;

import com.applitools.applifashion.pages.ui.AbstractGuiElement;
import com.applitools.applifashion.pages.ui.Input;
import com.applitools.applifashion.specification.FooterSpecification;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Footer extends AbstractGuiElement {

    @FindBy(css = ".links")
    private WebElement quickLinksList;

    @FindBy(css = ".contacts")
    private WebElement contacts;

    @FindBy(id = "email_newsletter")
    private WebElement emailInput;

    public Footer(WebElement element) {
        super(element);
    }

    public QuickLinksSection quickLinksSection() {
        return new QuickLinksSection(quickLinksList);
    }

    public ContactsSection contactsSection() {
        return new ContactsSection(contacts);
    }

    public Input emailInputField() {
        return new Input(emailInput);
    }

    public void validate(SoftAssertions softAssertions, int task) {
        new FooterSpecification(this, softAssertions, task).validate();
    }
}
