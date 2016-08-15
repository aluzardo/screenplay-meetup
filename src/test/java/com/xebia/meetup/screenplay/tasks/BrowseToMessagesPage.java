package com.xebia.meetup.screenplay.tasks;

import com.xebia.meetup.screenplay.ui.HeaderNavigation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

/**
 * Created by jochum on 15/08/16.
 */
public class BrowseToMessagesPage implements Task {
    @Override
    @Step("clicks the login link")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HeaderNavigation.MESSAGES)
        );
    }
}
