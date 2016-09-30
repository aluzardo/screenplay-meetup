package com.xebia.meetup.pageobjects.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://www.meetup.com")
public class MeetUpLandingPage extends PageObject {

    @FindBy(css="#authItem a[href*=\"login\"]")
    WebElementFacade loginLink;

    public void goto_login_page() {
        loginLink.click();
    }
}
