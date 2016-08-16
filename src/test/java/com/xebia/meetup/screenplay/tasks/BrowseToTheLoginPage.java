package com.xebia.meetup.screenplay.tasks;

import com.xebia.meetup.screenplay.ui.MeetUpLandingPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class BrowseToTheLoginPage implements Task {

    @Override
    @Step("clicks the login link")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(MeetUpLandingPage.LOGIN_LINK)
        );
    }
}
