package com.xebia.meetup.screenplay.features.basics;

import com.xebia.meetup.screenplay.abilities.Authenticate;
import com.xebia.meetup.utils.Credentials;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;

import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SerenityRunner.class)
@WithTag("Screenplay")
public class LoginAndLogoutTest {

    Actor anna = Actor.named("Anna");
    Credentials c = Credentials.getInstance();

    @Test
    public void can_authenticate() {
        anna.can(Authenticate.withCredentials(c.getUsername(), c.getPassword()));
        Authenticate.as(anna);
    }

}
