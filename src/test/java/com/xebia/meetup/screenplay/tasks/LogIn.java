package com.xebia.meetup.screenplay.tasks;

import com.xebia.meetup.screenplay.abilities.Authenticate;
import com.xebia.meetup.screenplay.ui.HeaderNavigation;
import com.xebia.meetup.screenplay.ui.LoginPage;
import com.xebia.meetup.screenplay.ui.MeetUpLandingPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.CurrentVisibility;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Cookie;

import java.util.Date;

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
        // Here a cookie is set to disable a promo popup
        BrowseTheWeb.as(actor).getDriver().manage().addCookie(
                new Cookie("app_download_promo_accepted", "dismissed=1", ".meetup.com", "/",
                        new Date(new Date().getTime() + (1000 * 60 * 60 * 24)))
        );

        // TODO: finish the implementation of this task
        actor.attemptsTo(
                Enter.theValue(authenticated(actor).username())
                        .into(/* username field */)//, <- Actions are comma separated
                // ACTION: enter password
                // ACTION: click login button
        );
    }

    private Authenticate authenticated(Actor actor) {
        return Authenticate.as(actor);
    }
}
