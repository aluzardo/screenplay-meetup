package com.xebia.meetup.screenplay.tasks.login;

import com.xebia.meetup.screenplay.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

/**
 * Created by jochum on 15/08/16.
 */
public class OpenTheLoginPage implements Task {
    LoginPage loginPage;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(loginPage)
        );
    }
}
