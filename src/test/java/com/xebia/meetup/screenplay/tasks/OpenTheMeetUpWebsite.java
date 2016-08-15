package com.xebia.meetup.screenplay.tasks;

import com.xebia.meetup.screenplay.ui.MeetUpLandingPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class OpenTheMeetUpWebsite implements Task {

    MeetUpLandingPage meetUpLandingPage;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(meetUpLandingPage)
        );
    }
}
