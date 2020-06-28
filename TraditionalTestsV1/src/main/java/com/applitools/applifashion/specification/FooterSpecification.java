package com.applitools.applifashion.specification;

import com.applitools.applifashion.pages.Footer;
import org.assertj.core.api.SoftAssertions;

public class FooterSpecification extends Specification {

    private Footer footer;

    public FooterSpecification(Footer footer, SoftAssertions softAssertions, int task) {
        super(softAssertions, task);
        this.footer = footer;
    }

    @Override
    protected void validate1200x700() {
        expectIsDisplayed(footer.quickLinksSection(), "'QUICK LINKS' section");
        expectIsDisplayed(footer.contactsSection(), "'CONTACTS' section");
        expectIsDisplayed(footer.emailInputField(), "'Your email' input field");
    }

    @Override
    protected void validate768x700() {
        expectIsDisplayed(footer.quickLinksSection(), "'QUICK LINKS' section");
        expectIsDisplayed(footer.contactsSection(), "'CONTACTS' section");
        expectIsDisplayed(footer.emailInputField(), "'Your email' input field");
    }

    @Override
    protected void validate500x700() {
        expectIsHidden(footer.quickLinksSection(), "'QUICK LINKS' section");
        expectIsHidden(footer.contactsSection(), "'CONTACTS' section");
        expectIsHidden(footer.emailInputField(), "'Your email' input field");
    }
}
