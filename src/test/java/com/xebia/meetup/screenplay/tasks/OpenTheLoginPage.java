package com.xebia.meetup.screenplay.tasks;

import com.xebia.meetup.screenplay.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

/*
 * Skip the MeetUp landing page and open the login page directly
 */
public class OpenTheLoginPage implements Task {
    LoginPage loginPage;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                //TODO: perform the action to open the Login Page
        );
    }
}
