package com.xebia.meetup.screenplay.tasks;

import com.xebia.meetup.screenplay.abilities.Authenticate;
import com.xebia.meetup.screenplay.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LogIn implements Task {

    public static LogIn withCredentials() {
        return instrumented(LogIn.class);
    }

    public static LogIn withFacebook() {
        throw new RuntimeException("Not yet implemented.");
    }

    @Override
    @Step("logs in as: {0}")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(authenticated(actor).username())
                        .into(LoginPage.USERNAME_FIELD),
                Enter.theValue(authenticated(actor).password())
                        .into(LoginPage.PASSWORD_FIELD),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }

    private Authenticate authenticated(Actor actor) {
        return Authenticate.as(actor);
    }
}
