package com.xebia.meetup.screenplay.features.basics;

import com.xebia.meetup.screenplay.abilities.Authenticate;
import com.xebia.meetup.utils.Credentials;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@RunWith(SerenityRunner.class)
@WithTag("Screenplay")
public class LoginAndLogoutTest {

    Actor anna = Actor.named("Anna");
    Credentials c = Credentials.getInstance();

    @Managed
    WebDriver herBrowser;

    @Test
    public void can_browse_the_web() {
        anna.can(BrowseTheWeb.with(herBrowser));
        BrowseTheWeb.as(anna);
    }

    @Test
    public void can_authenticate() {
        anna.can(Authenticate.withCredentials(c.getUsername(), c.getPassword()));
        Authenticate.as(anna);
    }

}
