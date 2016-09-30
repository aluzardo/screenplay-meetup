package com.xebia.meetup.pageobjects.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Cookie;

import java.util.Date;

@DefaultUrl("https://secure.meetup.com/login/")
public class LoginPage extends PageObject {

    @FindBy(id="email")
    WebElementFacade usernameField;

    @FindBy(id="password")
    WebElementFacade passwordField;

    @FindBy(name="submitButton")
    WebElementFacade loginButton;

    public void login_with_credentials(String username, String password) {
        set_cookies();
        usernameField.type(username);
        passwordField.type(password);
        loginButton.click();
    }

    private void set_cookies() {
        this.getDriver().manage().addCookie(new Cookie("app_download_promo_accepted", "dismissed=1", ".meetup.com", "/",
                        new Date(new Date().getTime() + (1000 * 60 * 60 * 24)))
        );
    }
}
