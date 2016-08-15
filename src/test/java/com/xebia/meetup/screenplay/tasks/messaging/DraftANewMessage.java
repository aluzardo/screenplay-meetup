package com.xebia.meetup.screenplay.tasks.messaging;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

/**
 * Created by jochum on 15/08/16.
 */
public class DraftANewMessage implements Task {

    private String username;
    private String message;

    public static DraftANewMessage forUser(String username) {
        return null;
    }

    public static DraftANewMessage withText(String message) {
        return null;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

    }
}
