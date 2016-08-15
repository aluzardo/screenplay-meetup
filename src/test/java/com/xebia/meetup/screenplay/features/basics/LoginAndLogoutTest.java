package com.xebia.meetup.screenplay.features.basics;

import com.xebia.meetup.screenplay.abilities.Authenticate;
import com.xebia.meetup.screenplay.tasks.BrowseToTheLoginPage;
import com.xebia.meetup.screenplay.tasks.LogIn;
import com.xebia.meetup.screenplay.tasks.LogOut;
import com.xebia.meetup.screenplay.tasks.OpenTheMeetUpWebsite;
import com.xebia.meetup.screenplay.questions.TheUserAvatarIsVisible;

import com.xebia.meetup.utils.Credentials;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.*;

/**
 * Created by jochum on 15/08/16.
 */
@RunWith(SerenityRunner.class)
public class LoginAndLogoutTest {

    Actor anna = Actor.named("Anna");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Steps OpenTheMeetUpWebsite openTheMeetUpWebsite;
    @Steps BrowseToTheLoginPage browseToTheLoginPage;
    @Steps LogOut logOut;

    @Before
    public void declare_her_abilities() {
        Credentials c = Credentials.getInstance();
        anna.can(BrowseTheWeb.with(herBrowser))
                .can(Authenticate.withCredentials(c.getUsername(), c.getPassword()));
    }

    @Test
    public void login_with_credentials() {
        givenThat(anna).wasAbleTo(openTheMeetUpWebsite);

        when(anna).wasAbleTo(browseToTheLoginPage);
        and(anna).attemptsTo(LogIn.withCredentials());

        then(anna).should(eventually(seeThat(new TheUserAvatarIsVisible())));
    }

    @After
    public void logout() {
        anna.attemptsTo(logOut);
    }

}
