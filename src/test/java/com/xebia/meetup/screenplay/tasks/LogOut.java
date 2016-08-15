package com.xebia.meetup.screenplay.tasks;

import com.xebia.meetup.screenplay.ui.HeaderNavigation.AccountDropdown;
import com.xebia.meetup.screenplay.ui.HeaderNavigation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

/**
 * Created by jochum on 15/08/16.
 */
public class LogOut implements Task {

    @Override
    @Step("logs out")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HeaderNavigation.ACCOUNT_DROPDOWN),
                Click.on(AccountDropdown.LOGOUT_LINK)
        );
    }
}
