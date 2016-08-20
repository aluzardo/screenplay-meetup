package com.xebia.meetup.screenplay.tasks;

import com.xebia.meetup.screenplay.ui.HeaderNavigation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class LogOut implements Task {

    @Override
    @Step("logs out")
    public <T extends Actor> void performAs(T actor) {
        // TODO: perform the task to Logout, using all needed Actions
        throw new RuntimeException("Logout task not yet implemented");
    }
}
