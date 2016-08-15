package com.xebia.meetup.screenplay.tasks;

import com.xebia.meetup.screenplay.ui.UserMenu;
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
                Click.on(UserMenu.SHOW_DROPDOWN),
                Click.on(UserMenu.LOGOUT_LINK)
        );
    }
}
