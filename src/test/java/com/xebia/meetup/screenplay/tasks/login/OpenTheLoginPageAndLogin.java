package com.xebia.meetup.screenplay.tasks.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Steps;

/**
 * Created by jochum on 15/08/16.
 */
public class OpenTheLoginPageAndLogin implements Task {

    @Steps
    OpenTheLoginPage openTheLoginPage;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                openTheLoginPage,
                LogIn.withCredentials()
        );
    }
}
