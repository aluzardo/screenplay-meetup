package com.xebia.meetup.pageobjects.features.basics;

import com.xebia.meetup.pageobjects.steps.MeetUpUserSteps;
import com.xebia.meetup.utils.Credentials;
import net.serenitybdd.junit.runners.SerenityRunner;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
@WithTag("PageObjects")
public class LoginAndLogoutTest {

    @Managed
    WebDriver driver;

    @Steps
    MeetUpUserSteps anna;

    @Before
    public void set_up() {
        Credentials c = Credentials.getInstance();
        anna.supplies_credentials(c);
    }

    @Test
    public void login_with_credentials() {
        // GIVEN
        anna.opens_the_meetup_website();

        // WHEN
        anna.browses_to_the_login_page();
        anna.logs_in_with_credentials();

        // THEN
        anna.should_see_the_profile_avatar();
    }

    @Test
    @Ignore
    public void login_with_facebook() {
        // GIVEN
        anna.opens_the_meetup_login_page();

        // WHEN
        anna.logs_in_via_facebook();

        // THEN
        anna.should_see_the_profile_avatar();
    }

    @After
    public void logout() {
        anna.logs_out();
    }

}
