package com.xebia.meetup.pageobjects.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://secure.meetup.com/login/")
public class LoginPage extends PageObject {

    @FindBy(id="email")
    WebElementFacade usernameField;

    @FindBy(id="password")
    WebElementFacade passwordField;

    @FindBy(name="submitButton")
    WebElementFacade loginButton;

    public void login_with_credentials(String username, String password) {
        usernameField.type(username);
        passwordField.type(password);
        loginButton.click();
    }
}
